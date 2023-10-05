package com.ayush.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic("kafka-demo", 3, (short) 1);
    }

}
