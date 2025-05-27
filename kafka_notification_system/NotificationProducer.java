package com.codility.kafka;

import com.codility.event.Notification;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationProducer {

    private final String smsTopicName;
    private final String mailTopicName;
    private final KafkaTemplate<String, Notification> kafkaTemplate;

    public NotificationProducer(
            @Value("${kafka.topics.sms}") String smsTopicName,
            @Value("${kafka.topics.mail}") String mailTopicName,
            KafkaTemplate<String, Notification> kafkaTemplate) {
        this.smsTopicName = smsTopicName;
        this.mailTopicName = mailTopicName;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSms(Notification notification) {
        kafkaTemplate.send(smsTopicName, notification);
    }

    public void sendMail(Notification notification) {
        kafkaTemplate.send(mailTopicName, notification);
    }
}
