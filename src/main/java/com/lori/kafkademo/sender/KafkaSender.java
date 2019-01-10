package com.lori.kafkademo.sender;

import com.lori.kafkademo.common.KafkaConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;

@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendTest(Integer count){
        System.out.println("发送消息次数： "+count);
        ListenableFuture<SendResult> listenableFuture = kafkaTemplate.send(KafkaConstants.TOPIC_TEST,"hello,kafka "+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"))+" --> "+count);
        try {
            SendResult sendResult = listenableFuture.get();
            System.out.println("发送成功！ 发送主题为： "+sendResult.getProducerRecord().topic()+" 发送的消息为: "+sendResult.getProducerRecord().value().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
