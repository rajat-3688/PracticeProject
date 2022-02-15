package com.softwareag.integration.messages;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class SampleMessages implements Message {
    @Override
    public Object getPayload() {
        return null;
    }

    @Override
    public MessageHeaders getHeaders() {
        return null;
    }
}
