package com.codility.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Value("${kafka.topics.sms}")
    private String smsTopic;

    @Value("${kafka.topics.mail}")
    private String mailTopic;

    @Bean
    public NewTopic smsNotificationTopic() {
        return TopicBuilder.name(smsTopic).partitions(1).replicas(1).build();
    }

    @Bean
    public NewTopic mailNotificationTopic() {
        return TopicBuilder.name(mailTopic).partitions(2).replicas(1).build();
    }
}
