package com.kafka.mahesh.kafkaproducer.resource;

import com.kafka.mahesh.kafkaproducer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    private String topic = "Kafka_Example";

    @GetMapping("/kafka/{message}")
    public String sendKafkaMessage(@PathVariable("message") String message) {

        kafkaTemplate.send(topic,new User("a","b",new Long(123)));
        return "successful" + message;
    }
}
