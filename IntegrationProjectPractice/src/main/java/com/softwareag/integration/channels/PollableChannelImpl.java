package com.softwareag.integration.channels;

import com.softwareag.integration.payload.BusinessData;
import org.springframework.messaging.Message;
import org.springframework.messaging.PollableChannel;

public class PollableChannelImpl implements PollableChannel {
    @Override
    public Message<?> receive() {
        return null;
    }

    @Override
    public Message<?> receive(long l) {
        return null;
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
