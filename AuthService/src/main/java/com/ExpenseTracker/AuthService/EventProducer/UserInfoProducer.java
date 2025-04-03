package com.ExpenseTracker.AuthService.EventProducer;

import com.ExpenseTracker.AuthService.Model.UserInfoDto;

import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoProducer {

    private final KafkaTemplate<String, UserInfoDto> kafkaTemplate;

    @Value("${spring.kafka.topic.name}")
    private String TOPIC;

    @Autowired
    public UserInfoProducer(KafkaTemplate<String, UserInfoDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void addTopicToKafka(UserInfoEvent userInfoDto) {
        Message<UserInfoEvent> userInfoDtoMessage = MessageBuilder.withPayload(userInfoDto)
                .setHeader(KafkaHeaders.TOPIC,TOPIC).build();
        this.kafkaTemplate.send(userInfoDtoMessage);
    }
}
