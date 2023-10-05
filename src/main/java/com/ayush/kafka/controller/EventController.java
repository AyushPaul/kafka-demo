package com.ayush.kafka.controller;

import com.ayush.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class EventController {
    @Autowired
    public KafkaProducerService kafkaProducerService;

    @GetMapping("/produce/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable String message){
        try {
            kafkaProducerService.sendMessageToTopic(message);

            return ResponseEntity.ok("Message Published Successfully!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }


    }
}
