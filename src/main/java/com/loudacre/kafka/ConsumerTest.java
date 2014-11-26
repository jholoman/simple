package com.loudacre.kafka;

import java.util.Properties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


import kafka.consumer.ConsumerIterator;
import kafka.consumer.ConsumerTimeoutException;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.consumer.ConsumerConfig;


import kafka.message.MessageAndMetadata;
import kafka.serializer.Decoder;
import kafka.serializer.StringDecoder;
import kafka.utils.VerifiableProperties;
import org.apache.log4j.Logger;

/**
 * Created by jholoman on 11/15/14.
 */
public class ConsumerTest {
    private static final Logger log = Logger.getLogger(ConsumerTest.class);

    public static void main(String[] args) {
        String topic = args[0];
        Properties props = new Properties();
        props.put("zookeeper.connect", "odell-test-2.ent.cloudera.com:2181/kafka");
        props.put("group.id", "java");
        props.put("zookeeper.session.timeout.ms", "2000");
        props.put("zookeeper.sync.time.ms", "200");
        props.put("auto.commit.interval.ms", "1000");
        ConsumerConfig config = new ConsumerConfig(props);

        ConsumerConnector c = kafka.consumer.Consumer.createJavaConsumerConnector(config);
        Map<String, Integer> topicMap = new HashMap<String, Integer>();
        topicMap.put(topic, 1);

        Decoder<String> d = new StringDecoder(new VerifiableProperties(props));
        Map<String, List<KafkaStream<String, String>>> streams = c.createMessageStreams(topicMap, d, d);

        KafkaStream<String, String> stream = streams.get(topic).get(0);

        ConsumerIterator<String, String> it = stream.iterator();
        while(it.hasNext()) {
            MessageAndMetadata<String, String> msg = it.next();
            //System.out.println(msg.key() + "," + msg.message());
            log.info(msg.message());
        }
    }

}
