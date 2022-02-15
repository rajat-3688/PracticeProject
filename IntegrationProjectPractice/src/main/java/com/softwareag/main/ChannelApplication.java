package com.softwareag.main;

import com.softwareag.integration.channels.BusinessChannelSender;
import com.softwareag.integration.handler.BusinessDataMessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@ComponentScan(basePackages = "com.softwareag.integration")
public class ChannelApplication {

    //@Autowired
    private DirectChannel channelLibrary = new DirectChannel();

    @Autowired
    private BusinessChannelSender businessChannelSender;

    @Bean
    public MessageChannel businessDataChannel() {
        channelLibrary = new DirectChannel();
        return channelLibrary;
    }

    public static void main(String[] args) {
        SpringApplication.run(ChannelApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            channelLibrary.subscribe(new BusinessDataMessageHandler());
            channelLibrary.subscribe(new BusinessDataMessageHandler());
            channelLibrary.subscribe(new BusinessDataMessageHandler());
            channelLibrary.subscribe(new BusinessDataMessageHandler());
            channelLibrary.subscribe(new BusinessDataMessageHandler());

            businessChannelSender.sendBusinessData();
        };
    }
}
