package com.loudacre.kafka.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.avro.AvroFactory;
import com.fasterxml.jackson.dataformat.avro.AvroSchema;
import com.fasterxml.jackson.dataformat.avro.schema.AvroSchemaGenerator;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * Created by jholoman on 11/22/14.
 */
public class EventPOJO {

    public enum experience { POSITIVE("Positive"),
                             NEGATIVE("Negative"),
                             NEUTRAL("Neutral");

        private String name;
        experience(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public enum priority {HIGH("High"),
                          MEDIUM("Medium"),
                          LOW("Low");
        private String name;
        priority(String name) { this.name = name; }
        public String getName() { return name; }
    }

    public enum product { BANKING("Banking"),
                          SOMETHING("Something"),
                          SOMETHING2("Something2");

        private String name;
        product(String name) { this.name = name; }
        public String getName() { return name; }

    };
    public enum browser{ MOZ("Mozilla"),
                         CHROME("Chrome"),
                         SAFARI("Safari");
        private String name;
        browser(String name) { this.name = name; }
        public String getName() { return name; }

    }; // Fix
    public enum eventSource{OLB("OLB"),LOB("LOB"),BLO("BLOW");

        private String name;
        eventSource(String name) { this.name = name; }
        public String getName() { return name; }
    };
    String accountID;
    String eventType;
    String eventUUID;
    String sessionID;
    int sourceEventID;
    String eventDate;
    int channelID;
    String interactionChannel;
    String cehUUID;
    int partyID;
    String onlineID;
    String eventAction;
    String attrString1;
    int attrint1;
    double attrdouble1;
    String attrString2;
    int attrint2;
    double attrdouble2;
    String attrString3;
    int attrint3;
    double attrdouble3;
    String attrString4;
    int attrint4;
    double attrdouble4;
    String attrString5;
    int attrint5;
    double attrdouble5;
    String attrString6;
    int attrint6;
    String attrString7;
    int attrint7;
    String attrString8;
    int attrint8;
    String attrString9;
    int attrint9;
    String attrString10;
    int attrint10;
    String attrString11;
    int attrint11;
    String attrString12;
    int attrint12;
    String attrString13;
    int attrint13;
    String attrString14;
    int attrint14;
    String attrString15;
    int attrint15;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EventPOJO{");
        sb.append("accountID='").append(accountID).append('\'');
        sb.append(", eventType='").append(eventType).append('\'');
        sb.append(", eventUUID='").append(eventUUID).append('\'');
        sb.append(", sessionID='").append(sessionID).append('\'');
        sb.append(", sourceEventID=").append(sourceEventID);
        sb.append(", eventDate='").append(eventDate).append('\'');
        sb.append(", channelID=").append(channelID);
        sb.append(", interactionChannel='").append(interactionChannel).append('\'');
        sb.append(", cehUUID='").append(cehUUID).append('\'');
        sb.append(", partyID=").append(partyID);
        sb.append(", onlineID='").append(onlineID).append('\'');
        sb.append(", eventAction='").append(eventAction).append('\'');
        sb.append(", attrString1='").append(attrString1).append('\'');
        sb.append(", attrint1=").append(attrint1);
        sb.append(", attrdouble1=").append(attrdouble1);
        sb.append(", attrString2='").append(attrString2).append('\'');
        sb.append(", attrint2=").append(attrint2);
        sb.append(", attrdouble2=").append(attrdouble2);
        sb.append(", attrString3='").append(attrString3).append('\'');
        sb.append(", attrint3=").append(attrint3);
        sb.append(", attrdouble3=").append(attrdouble3);
        sb.append(", attrString4='").append(attrString4).append('\'');
        sb.append(", attrint4=").append(attrint4);
        sb.append(", attrdouble4=").append(attrdouble4);
        sb.append(", attrString5='").append(attrString5).append('\'');
        sb.append(", attrint5=").append(attrint5);
        sb.append(", attrdouble5=").append(attrdouble5);
        sb.append(", attrString6='").append(attrString6).append('\'');
        sb.append(", attrint6=").append(attrint6);
        sb.append(", attrString7='").append(attrString7).append('\'');
        sb.append(", attrint7=").append(attrint7);
        sb.append(", attrString8='").append(attrString8).append('\'');
        sb.append(", attrint8=").append(attrint8);
        sb.append(", attrString9='").append(attrString9).append('\'');
        sb.append(", attrint9=").append(attrint9);
        sb.append(", attrString10='").append(attrString10).append('\'');
        sb.append(", attrint10=").append(attrint10);
        sb.append(", attrString11='").append(attrString11).append('\'');
        sb.append(", attrint11=").append(attrint11);
        sb.append(", attrString12='").append(attrString12).append('\'');
        sb.append(", attrint12=").append(attrint12);
        sb.append(", attrString13='").append(attrString13).append('\'');
        sb.append(", attrint13=").append(attrint13);
        sb.append(", attrString14='").append(attrString14).append('\'');
        sb.append(", attrint14=").append(attrint14);
        sb.append(", attrString15='").append(attrString15).append('\'');
        sb.append(", attrint15=").append(attrint15);
        sb.append('}');
        return sb.toString();
    }

    public String toJSon(boolean pretty) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD,JsonAutoDetect.Visibility.ANY);
        if (pretty) {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } else {
            return mapper.writeValueAsString(this);
        }
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventUUID() {
        return eventUUID;
    }

    public void setEventUUID(String eventUUID) {
        this.eventUUID = eventUUID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public int getSourceEventID() {
        return sourceEventID;
    }

    public void setSourceEventID(int sourceEventID) {
        this.sourceEventID = sourceEventID;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public String getInteractionChannel() {
        return interactionChannel;
    }

    public void setInteractionChannel(String interactionChannel) {
        this.interactionChannel = interactionChannel;
    }

    public String getCehUUID() {
        return cehUUID;
    }

    public void setCehUUID(String cehUUID) {
        this.cehUUID = cehUUID;
    }

    public int getPartyID() {
        return partyID;
    }

    public void setPartyID(int partyID) {
        this.partyID = partyID;
    }

    public String getOnlineID() {
        return onlineID;
    }

    public void setOnlineID(String onlineID) {
        this.onlineID = onlineID;
    }

    public String getEventAction() {
        return eventAction;
    }

    public void setEventAction(String eventAction) {
        this.eventAction = eventAction;
    }

    public String getAttrString1() {
        return attrString1;
    }

    public void setAttrString1(String attrString1) {
        this.attrString1 = attrString1;
    }

    public int getAttrint1() {
        return attrint1;
    }

    public void setAttrint1(int attrint1) {
        this.attrint1 = attrint1;
    }

    public double getAttrdouble1() {
        return attrdouble1;
    }

    public void setAttrdouble1(double attrdouble1) {
        this.attrdouble1 = attrdouble1;
    }

    public String getAttrString2() {
        return attrString2;
    }

    public void setAttrString2(String attrString2) {
        this.attrString2 = attrString2;
    }

    public int getAttrint2() {
        return attrint2;
    }

    public void setAttrint2(int attrint2) {
        this.attrint2 = attrint2;
    }

    public double getAttrdouble2() {
        return attrdouble2;
    }

    public void setAttrdouble2(double attrdouble2) {
        this.attrdouble2 = attrdouble2;
    }

    public String getAttrString3() {
        return attrString3;
    }

    public void setAttrString3(String attrString3) {
        this.attrString3 = attrString3;
    }

    public int getAttrint3() {
        return attrint3;
    }

    public void setAttrint3(int attrint3) {
        this.attrint3 = attrint3;
    }

    public double getAttrdouble3() {
        return attrdouble3;
    }

    public void setAttrdouble3(double attrdouble3) {
        this.attrdouble3 = attrdouble3;
    }

    public String getAttrString4() {
        return attrString4;
    }

    public void setAttrString4(String attrString4) {
        this.attrString4 = attrString4;
    }

    public int getAttrint4() {
        return attrint4;
    }

    public void setAttrint4(int attrint4) {
        this.attrint4 = attrint4;
    }

    public double getAttrdouble4() {
        return attrdouble4;
    }

    public void setAttrdouble4(double attrdouble4) {
        this.attrdouble4 = attrdouble4;
    }

    public String getAttrString5() {
        return attrString5;
    }

    public void setAttrString5(String attrString5) {
        this.attrString5 = attrString5;
    }

    public int getAttrint5() {
        return attrint5;
    }

    public void setAttrint5(int attrint5) {
        this.attrint5 = attrint5;
    }

    public double getAttrdouble5() {
        return attrdouble5;
    }

    public void setAttrdouble5(double attrdouble5) {
        this.attrdouble5 = attrdouble5;
    }

    public String getAttrString6() {
        return attrString6;
    }

    public void setAttrString6(String attrString6) {
        this.attrString6 = attrString6;
    }

    public int getAttrint6() {
        return attrint6;
    }

    public void setAttrint6(int attrint6) {
        this.attrint6 = attrint6;
    }

    public String getAttrString7() {
        return attrString7;
    }

    public void setAttrString7(String attrString7) {
        this.attrString7 = attrString7;
    }

    public int getAttrint7() {
        return attrint7;
    }

    public void setAttrint7(int attrint7) {
        this.attrint7 = attrint7;
    }

    public String getAttrString8() {
        return attrString8;
    }

    public void setAttrString8(String attrString8) {
        this.attrString8 = attrString8;
    }

    public int getAttrint8() {
        return attrint8;
    }

    public void setAttrint8(int attrint8) {
        this.attrint8 = attrint8;
    }

    public String getAttrString9() {
        return attrString9;
    }

    public void setAttrString9(String attrString9) {
        this.attrString9 = attrString9;
    }

    public int getAttrint9() {
        return attrint9;
    }

    public void setAttrint9(int attrint9) {
        this.attrint9 = attrint9;
    }

    public String getAttrString10() {
        return attrString10;
    }

    public void setAttrString10(String attrString10) {
        this.attrString10 = attrString10;
    }

    public int getAttrint10() {
        return attrint10;
    }

    public void setAttrint10(int attrint10) {
        this.attrint10 = attrint10;
    }

    public String getAttrString11() {
        return attrString11;
    }

    public void setAttrString11(String attrString11) {
        this.attrString11 = attrString11;
    }

    public int getAttrint11() {
        return attrint11;
    }

    public void setAttrint11(int attrint11) {
        this.attrint11 = attrint11;
    }

    public String getAttrString12() {
        return attrString12;
    }

    public void setAttrString12(String attrString12) {
        this.attrString12 = attrString12;
    }

    public int getAttrint12() {
        return attrint12;
    }

    public void setAttrint12(int attrint12) {
        this.attrint12 = attrint12;
    }

    public String getAttrString13() {
        return attrString13;
    }

    public void setAttrString13(String attrString13) {
        this.attrString13 = attrString13;
    }

    public int getAttrint13() {
        return attrint13;
    }

    public void setAttrint13(int attrint13) {
        this.attrint13 = attrint13;
    }

    public String getAttrString14() {
        return attrString14;
    }

    public void setAttrString14(String attrString14) {
        this.attrString14 = attrString14;
    }

    public int getAttrint14() {
        return attrint14;
    }

    public void setAttrint14(int attrint14) {
        this.attrint14 = attrint14;
    }

    public String getAttrString15() {
        return attrString15;
    }

    public void setAttrString15(String attrString15) {
        this.attrString15 = attrString15;
    }

    public int getAttrint15() {
        return attrint15;
    }

    public void setAttrint15(int attrint15) {
        this.attrint15 = attrint15;
    }

    /*public String getSchema () throws JsonMappingException {
        ObjectMapper mapper = new ObjectMapper(new AvroFactory());
        AvroSchemaGenerator gen = new AvroSchemaGenerator();
        mapper.acceptJsonFormatVisitor(EventPOJO.class, gen);
        AvroSchema schemaWrapper = gen.getGeneratedSchema();
        org.apache.avro.Schema avroSchema = schemaWrapper.getAvroSchema();
        String asJson = avroSchema.toString(true);
        return asJson;
    }
    */
}
