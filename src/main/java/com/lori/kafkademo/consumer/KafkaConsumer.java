package com.lori.kafkademo.consumer;

import com.lori.kafkademo.common.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = {KafkaConstants.TOPIC_TEST})
    public void receiveMessage(String message){
        System.out.println("接受到消息： "+message);
    }
}
