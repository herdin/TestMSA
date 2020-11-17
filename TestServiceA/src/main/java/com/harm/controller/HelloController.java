package com.harm.controller;

import com.harm.config.KafkaProducerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {
    Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    KafkaTemplate<String, KafkaProducerConfig.KafkaData> kafkaDataKafkaTemplate;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        logger.debug("hello -> {}", name);
        return "hello, " + name;
    }
    
    //test 로 get 만들었지만 post 가 옳다
    @GetMapping("/kafka/{data}")
    public ResponseEntity kafka(@PathVariable String data) {
        logger.debug("kafka produce -> {}", data);
        KafkaProducerConfig.KafkaData kafkaData = new KafkaProducerConfig.KafkaData();
        kafkaData.setMessage(data + ", " + LocalDateTime.now());
        kafkaData.setNum((long) (Math.random()*100));
        kafkaDataKafkaTemplate.send(KafkaProducerConfig.KAFKA_TEST_TOPIC, kafkaData);
        return ResponseEntity.ok(kafkaData);
    }
}
