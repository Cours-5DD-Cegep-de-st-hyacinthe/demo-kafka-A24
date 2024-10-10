package com.example.demo.controleur;

import com.example.demo.model.GameStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(originPatterns = "http://127.0.0.1:[*]", allowCredentials = "true")
@RequestMapping("/kafka")
@RestController
public class KafkaControleur {

    @KafkaListener(topics = "test_topic", groupId = "group1")
    public void listenTestTopic(String message) {
        System.out.println("Message reçu: " + message);
    }

    @KafkaListener(topics = "game_status_topic",
            groupId = "group1",
            containerFactory = "gameStatusKafkaListenerContainerFactory")
    public void listenTestTopic(GameStatus gameStatus) {
        System.out.println("Game status reçu: " + gameStatus.toString());
    }
}
