package com.example.demo.service;

import com.example.demo.model.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    private KafkaTemplate<String, String> kafkaTemplate;
    private KafkaTemplate<String, GameStatus> gameStatusKafkaTemplate;

    @Autowired
    public KafkaService(
            KafkaTemplate<String, String> kafkaTemplate,
            KafkaTemplate<String, GameStatus> gameStatusKafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.gameStatusKafkaTemplate = gameStatusKafkaTemplate;
    }

    public void send(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    public void sendGameStatus(String topic, GameStatus gameStatus) {
        gameStatusKafkaTemplate.send(topic, gameStatus);
    }
}
