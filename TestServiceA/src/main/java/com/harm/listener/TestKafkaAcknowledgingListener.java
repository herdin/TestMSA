package com.harm.listener;

import com.harm.config.KafkaProducerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class TestKafkaAcknowledgingListener implements AcknowledgingMessageListener<String, KafkaProducerConfig.KafkaData> {
    Logger logger = LoggerFactory.getLogger(TestKafkaAcknowledgingListener.class);
    @KafkaListener(topics = KafkaProducerConfig.KAFKA_TEST_TOPIC, containerFactory = "kafkaDataKafkaListenerContainerFactory")
    @Override
    public void onMessage(ConsumerRecord<String, KafkaProducerConfig.KafkaData> data, Acknowledgment acknowledgment) {
        KafkaProducerConfig.KafkaData kafkaData = data.value();
        boolean isOk = (kafkaData.getNum()%2 == 0);

        logger.debug("listen -> {}", data);
        if(isOk) {
            acknowledgment.acknowledge();
            logger.debug("acknowledge success.");
        } else {
            logger.debug("acknowledge fail.");
        }
    }
}
