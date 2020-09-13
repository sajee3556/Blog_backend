package com.sajee.blog.service.serviceImpl;

import com.sajee.blog.model.Content;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl {
    private static final Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);
    private static final String TOPIC = "content";

    @Autowired
    KafkaTemplate<String, Content> kafkaTemplate;

    public void sendMessage(Content content){
        logger.info("Received Message:  "+content);
        this.kafkaTemplate.send(TOPIC,content);
    }
}
