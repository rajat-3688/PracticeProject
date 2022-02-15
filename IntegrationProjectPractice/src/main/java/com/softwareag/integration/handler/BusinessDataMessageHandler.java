package com.softwareag.integration.handler;

import com.softwareag.integration.payload.BusinessData;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class BusinessDataMessageHandler implements MessageHandler {
    @Override
    public void handleMessage(Message<?> message) throws MessagingException {

        Object payloadData = message.getPayload();
        if(payloadData instanceof BusinessData) {
            receiveData((BusinessData) payloadData);
        }
    }

    private void receiveData(BusinessData data){
        System.out.println("Received Data "+ data.toString());
    }
}
