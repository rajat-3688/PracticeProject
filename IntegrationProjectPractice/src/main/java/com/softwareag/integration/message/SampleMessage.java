package com.softwareag.integration.message;

import com.softwareag.integration.payload.BusinessData;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.HashMap;
import java.util.Map;

public class SampleMessage implements Message<BusinessData> {
    @Override
    public BusinessData getPayload() {
        BusinessData data  = new BusinessData();
        data.setAddress("Bangalore");
        data.setAge(30);
        data.setName("BusinessData");
        return data;
    }

    @Override
    public MessageHeaders getHeaders() {
        Map<String, Object> headers = new HashMap<>();
        headers.put("header1", "Rajat");

        MessageHeaders messageHeaders = new MessageHeaders(headers);

        return messageHeaders;
    }
}
