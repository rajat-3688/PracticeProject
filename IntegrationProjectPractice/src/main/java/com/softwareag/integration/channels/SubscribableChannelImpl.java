package com.softwareag.integration.channels;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.SubscribableChannel;

public class SubscribableChannelImpl implements SubscribableChannel {
    @Override
    public boolean subscribe(MessageHandler messageHandler) {
        return false;
    }

    @Override
    public boolean unsubscribe(MessageHandler messageHandler) {
        return false;
    }

    @Override
    public boolean send(Message<?> message) {
        return false;
    }

    @Override
    public boolean send(Message<?> message, long l) {
        return false;
    }
}
