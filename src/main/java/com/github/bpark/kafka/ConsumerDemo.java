package com.github.bpark.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

public class ConsumerDemo {

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();

        props.put("bootstrap.servers", "192.168.77.7:9092,192.168.77.7:9093");
        //props.put("bootstrap.servers", "192.168.77.7:9093");
        props.put("group.id", "test-group-id");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singletonList("test"));

        System.out.println("Subscribed to topic test");

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)

                System.out.println(String.format("offset = %s, key = %s, value = %s", record.offset(), record.key(), record.value()));
        }
    }
}
