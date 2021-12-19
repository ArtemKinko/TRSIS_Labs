package com.service;

import com.model.Stamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private StampsService stampsService;

    @KafkaListener(topics = "stamps", groupId = "stamps")
    public void consume(Stamp stamp) {
        System.out.println("Consumed:" + stamp.toString());
        stampsService.add(stamp);
    }
}
