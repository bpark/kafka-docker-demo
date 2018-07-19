/*
 * Copyright 2017 Kurt Sparber
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.bpark.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class EndlessProducerDemo {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();

        props.put("bootstrap.servers", "192.168.77.7:9094,192.168.77.7:9093,192.168.77.7:9092");
        props.put("retries", 0);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        Timer timer = new Timer("Timer");

        TimerTask repeatedTask = new TimerTask() {

            private int counter;

            public void run() {
                String key = Long.toString(counter++);
                String value = Long.toString(System.currentTimeMillis());
                System.out.println("Emitting (" + key + ", " + value + ")");
                producer.send(new ProducerRecord<>("test", key, value));
            }
        };

        long delay  = 1000L;
        long period = 500L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        timer.cancel();

        producer.close();
    }
}
