package com.loudacre.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loudacre.kafka.model.Event;
import com.loudacre.kafka.model.EventPOJO;
import com.loudacre.kafka.util.EventUtils;
import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.List;
import java.util.Properties;

/**
 * Created by jholoman on 11/15/14.
 */
public class ProducerTest {
    private static final Logger log = Logger.getLogger(ProducerTest.class);
    private static List<KeyedMessage<String, byte[]>> messageList;

    public static void main(String[] args) throws Exception {

        if (args.length == 0) {

            System.out.println("---------");
            System.out.println("Producer <topic> <number of events> <json|avro>");
            System.out.println("---------");
            return;
        }
        String topic = args[0];
        long events = Long.parseLong(args[1]);
        String messageType = args[2];

        //sendMessages(topic,events,messageType);


    }

    public static void sendMessages(String topic, long events, String messageType) throws Exception {
        Properties props = new Properties();
        props.put("metadata.broker.list", "odell-test-3.ent.cloudera.com:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "-1");
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, byte[]> producer = new Producer<String, byte[]>(config);

        //Schema schema = new Schema.Parser().parse(new File("EventPOJO.avsc"));

        EventPOJO eventJson = new EventPOJO();
        Event eventAvro = new Event();

        log.info("starting batch");
        log.info(messageType);
        log.info(events);
        for (long nEvents = 0; nEvents < events; nEvents++) {
            String msg="";
            byte[] finalMessage = null;
            if (messageType.equals("json")) {
                try {
                    EventUtils.randomize(eventJson);
                    msg = eventJson.toJSon(false);
                    finalMessage = msg.getBytes();
                } catch (JsonProcessingException e) {
                    log.debug(e);
                }
            }
            else if (messageType.equals("avro")) {
                log.info("starting avro type");
                EventUtils.randomize(eventAvro);
                DatumWriter<Event> userDatumWriter = new SpecificDatumWriter<Event>(Event.class);
                DataFileWriter<Event> dataFileWriter = new DataFileWriter<Event>(userDatumWriter);
                dataFileWriter.create(eventAvro.getSchema(), new File("users.avro"));
                dataFileWriter.append(eventAvro);
                dataFileWriter.close();
                }

         //  KeyedMessage<String, byte[]> data = new KeyedMessage<String, byte[]>(topic, "", finalMessage);
          // messageList.add(data);
        }
        //producer.send(messageList);
        log.info("ending batch");
        producer.close();

       /*
        int len = 0;
        int jsonlen = 0;
        for (int i=0;i<100;i++) {
            event.randomize();
            len += event.toString().length();
            jsonlen += event.toJSon(false).length();
        }
        System.out.println("The average len is: "+ len/100);
        System.out.println("The average json length is: " + jsonlen / 100);
*/

    }
}


