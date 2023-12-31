package com.ayush.kafka.controller;

import com.ayush.kafka.dto.Customer;
import com.ayush.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/produce/bulk/{message}")
    public ResponseEntity<?> sendBulkMessage(@PathVariable String message){
        try {
            for(int i = 0 ; i<1000;i++){
                kafkaProducerService.sendMessageToTopic(message+" : "+ i);
            }
            return ResponseEntity.ok("Bulk Message Published Successfully!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/customer")
    public void sendEvents(@RequestBody Customer customer) {
        kafkaProducerService.sendEventsToTopic(customer);
    }
}
