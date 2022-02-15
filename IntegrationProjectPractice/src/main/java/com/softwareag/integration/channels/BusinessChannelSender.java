package com.softwareag.integration.channels;

import com.softwareag.integration.message.SampleMessage;
import com.softwareag.integration.payload.BusinessData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class BusinessChannelSender {
    private DirectChannel directChannel;

    @Value("#{businessDataChannel}")
    public void setDirectChannel(DirectChannel channel) {
        this.directChannel = channel;
    }

    public boolean sendBusinessData() {
        SampleMessage sampleMessage = new SampleMessage();
        Message message = MessageBuilder.withPayload(sampleMessage.getPayload()).setHeader("Header1", "Value1").build();
        System.out.println("Business Data  " + sampleMessage.toString());
        return directChannel.send(message);
    }


}
