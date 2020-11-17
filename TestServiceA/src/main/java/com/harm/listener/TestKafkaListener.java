package com.harm.listener;

import com.harm.config.KafkaProducerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

//@Component
public class TestKafkaListener implements MessageListener<String, KafkaProducerConfig.KafkaData> {
    Logger logger = LoggerFactory.getLogger(TestKafkaListener.class);
    @KafkaListener(topics = KafkaProducerConfig.KAFKA_TEST_TOPIC, containerFactory = "kafkaDataKafkaListenerContainerFactory")
    @Override
    public void onMessage(ConsumerRecord<String, KafkaProducerConfig.KafkaData> data) {
        logger.debug("listen -> {}", data);
        logger.debug("listen value -> {}", data.value());
    }
}
