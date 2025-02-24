package com.Kafka1.Kafka1.Controller;

import com.Kafka1.Kafka1.service.KafkaProducerService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        String topic = "my-topic";
        producerService.sendMessage(topic, message);
        return "Message sent to Kafka topic!";
    }
}
