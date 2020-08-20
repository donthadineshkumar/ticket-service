package com.epam.tickerservice;
/*
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;*/

import java.util.Properties;

/*@RestController
@RequestMapping(value = "/greetings")*/
public class HelloWorldProducer {

    /*@Autowired
    KafkaTemplate kafkaTemplate;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void sendMessage(){
        *//*Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);*//*
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("helloworld", null,
                "Hello world again!");

        kafkaTemplate.send("helloworld","Hello world again!");
        *//*producer.send(producerRecord);
        producer.close();*//*
    }*/
}
