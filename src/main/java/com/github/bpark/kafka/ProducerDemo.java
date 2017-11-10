package com.github.bpark.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerDemo {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();

        props.put("bootstrap.servers", "192.168.77.7:9092");
        //props.put("bootstrap.servers", "192.168.77.7:9092");
        props.put("retries", 0);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for(int i = 0; i < 10; i++) {
            producer.send(new ProducerRecord<>("test", Integer.toString(i), Integer.toString(i)));
            System.out.println("Sent message: " + i);
        }

        producer.flush();

        System.out.println("closing");

        producer.close();
    }
}
