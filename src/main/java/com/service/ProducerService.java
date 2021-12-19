package com.service;

import com.model.Stamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Stamp> template;

    public void produce(Stamp stamp) {
        System.out.println("Producing: " + stamp.toString());
        template.send("stamps", stamp);
    }
}
