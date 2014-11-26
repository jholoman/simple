package com.loudacre.kafka.util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.loudacre.kafka.model.Event;
import com.loudacre.kafka.model.EventPOJO;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jholoman on 11/23/14.
 */
public class EventUtils extends Event {

    public static void main (String[] args) throws IOException{

        if (args.length == 0) {

            System.out.println("---------");
            System.out.println("WriteTest <number of events> <json|avro|both>");
            System.out.println("---------");
            return;
        }
        long events = Long.parseLong(args[0]);
        String messageType = args[1];

        if (messageType.equals("json")||(messageType.equals("both"))) {
            writeJson(events);
        }
        if (messageType.equals("avro")|| (messageType.equals("both"))) {
            writeAvro(events);
        }
    }
    public static void randomize(Event event) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss.SSS");
        String now = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("#########.##");

        event.setAccountID("**-" + (RandomUtils.nextInt(1000, 9999)));
        event.setEventType(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(0, 50)));
        event.setEventUUID(String.valueOf(UUID.randomUUID()));
        event.setSessionID(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(0, 25)));
        event.setSourceEventID(RandomUtils.nextInt(0, 5));
        event.setEventDate(now);
        event.setChannelID(RandomUtils.nextInt(0, 10));
        event.setInteractionChannel(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(20, 255)));
        event.setCehUUID(String.valueOf(UUID.randomUUID()));
        event.setPartyID(RandomUtils.nextInt(0, 999999));
        event.setOnlineID(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(8, 30)));
        event.setEventAction(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(8, 100)));
        event.setAttrString1(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString2(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString3(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString4(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString5(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString6(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString7(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString8(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString9(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString10(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString11(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString12(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString13(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString14(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString15(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrint1(RandomUtils.nextInt(0, 99999999));
        event.setAttrint2(RandomUtils.nextInt(0, 99999999));
        event.setAttrint3(RandomUtils.nextInt(0, 99999999));
        event.setAttrint4(RandomUtils.nextInt(0, 99999999));
        event.setAttrint5(RandomUtils.nextInt(0, 99999999));
        event.setAttrint6(RandomUtils.nextInt(0, 99999999));
        event.setAttrint7(RandomUtils.nextInt(0, 99999999));
        event.setAttrint8(RandomUtils.nextInt(0, 99999999));
        event.setAttrint9(RandomUtils.nextInt(0, 99999999));
        event.setAttrint10(RandomUtils.nextInt(0, 99999999));
        event.setAttrint11(RandomUtils.nextInt(0, 99999999));
        event.setAttrint12(RandomUtils.nextInt(0, 99999999));
        event.setAttrint13(RandomUtils.nextInt(0, 99999999));
        event.setAttrint14(RandomUtils.nextInt(0, 99999999));
        event.setAttrdouble1(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
        event.setAttrdouble2(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
        event.setAttrdouble3(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
        event.setAttrdouble4(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
        event.setAttrdouble5(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
    }

    public static void randomize(EventPOJO event) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss.SSS");
        String now = sdf.format(new Date());
        DecimalFormat df = new DecimalFormat("#########.##");

        event.setAccountID("**-" + (RandomUtils.nextInt(1000, 9999)));
        event.setEventType(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(0, 50)));
        event.setEventUUID(String.valueOf(UUID.randomUUID()));
        event.setSessionID(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(0, 25)));
        event.setSourceEventID(RandomUtils.nextInt(0, 5));
        event.setEventDate(now);
        event.setChannelID(RandomUtils.nextInt(0, 10));
        event.setInteractionChannel(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(20, 255)));
        event.setCehUUID(String.valueOf(UUID.randomUUID()));
        event.setPartyID(RandomUtils.nextInt(0, 999999));
        event.setOnlineID(RandomStringUtils.randomAlphanumeric(RandomUtils.nextInt(8, 30)));
        event.setEventAction(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(8, 100)));
        event.setAttrString1(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString2(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString3(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString4(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString5(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString6(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString7(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString8(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString9(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString10(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString11(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString12(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString13(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString14(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrString15(RandomStringUtils.randomAlphabetic(RandomUtils.nextInt(0, 255)));
        event.setAttrint1(RandomUtils.nextInt(0, 99999999));
        event.setAttrint2(RandomUtils.nextInt(0, 99999999));
        event.setAttrint3(RandomUtils.nextInt(0, 99999999));
        event.setAttrint4(RandomUtils.nextInt(0, 99999999));
        event.setAttrint5(RandomUtils.nextInt(0, 99999999));
        event.setAttrint6(RandomUtils.nextInt(0, 99999999));
        event.setAttrint7(RandomUtils.nextInt(0, 99999999));
        event.setAttrint8(RandomUtils.nextInt(0, 99999999));
        event.setAttrint9(RandomUtils.nextInt(0, 99999999));
        event.setAttrint10(RandomUtils.nextInt(0, 99999999));
        event.setAttrint11(RandomUtils.nextInt(0, 99999999));
        event.setAttrint12(RandomUtils.nextInt(0, 99999999));
        event.setAttrint13(RandomUtils.nextInt(0, 99999999));
        event.setAttrint14(RandomUtils.nextInt(0, 99999999));
        event.setAttrint15(RandomUtils.nextInt(0, 99999999));
        event.setAttrdouble1(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
        event.setAttrdouble2(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
        event.setAttrdouble3(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
        event.setAttrdouble4(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
        event.setAttrdouble5(Math.floor(RandomUtils.nextDouble(0.00, 999999.99) * 100) / 100);
    }

    public static void writeAvro(Long events) throws IOException {
        Event eventAvro = new Event();
        DatumWriter<Event> userDatumWriter = new SpecificDatumWriter<Event>(Event.class);
        DataFileWriter<Event> dataFileWriter = new DataFileWriter<Event>(userDatumWriter)
                //.setCodec(CodecFactory.snappyCodec());
                ;
        dataFileWriter.create(eventAvro.getSchema(), new File("event-"+events+".avro"));

        for (long nEvents = 0; nEvents < events; nEvents++) {
            randomize(eventAvro);
            dataFileWriter.append(eventAvro);
        }
        dataFileWriter.close();
    }

    public static void writeJson(Long events) throws IOException {
        EventPOJO eventJson = new EventPOJO();
        randomize(eventJson);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        FileOutputStream stream = new FileOutputStream("event-"+events+".json");
        for (long nEvents = 0; nEvents < events; nEvents++) {
            EventUtils.randomize(eventJson);
            mapper.writerWithDefaultPrettyPrinter().writeValue(os, eventJson);
        }
        os.writeTo(stream);
        os.close();
        stream.close();
    }

    public static String SortGroupConcat() {
            String joinedResult = "";
            String x = "\"b\",   \"c\", \"a\"";
            try {
                //String[] temp = x.toString().replace("\"","").split(",");
                String[] temp = x.toString().split(",");
                String[] trimmedArray = new String[temp.length];
                for (int i = 0; i < temp.length; i++) {
                    trimmedArray[i] = temp[i].trim();
                    System.out.println(temp[i]);
                    System.out.println(temp[i].trim());
                }
                List<String> items = Arrays.asList(trimmedArray);
                //List<String> items = Arrays.asList(x.toString().split(","));
                System.out.println(items.toString());
                java.util.Collections.sort(items);
                joinedResult = StringUtils.join(items, ",");
                System.out.println(joinedResult);
            } catch (Exception e) {
                System.out.println(e);
            }
            return joinedResult;
        }
}

