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

public class ProducerCallbackDemo {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();

        props.put("bootstrap.servers", "192.168.77.7:9092");
        props.put("retries", 3);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        /*
        This means the leader will wait for the full set of in-sync replicas to acknowledge the record. This guarantees
        that the record will not be lost as long as at least one in-sync replica remains alive. This is the strongest
        available guarantee. This is equivalent to the acks=-1 setting.
         */
        props.put("acks", "all");

        /*
        If set to zero then the producer will not wait for any acknowledgment from the server at all. The record will be
        immediately added to the socket buffer and considered sent. No guarantee can be made that the server has received
        the record in this case, and the retries configuration will not take effect (as the client won't generally know
        of any failures). The offset given back for each record will always be set to -1.
         */
        //props.put("acks", "0");

        /*
        This will mean the leader will write the record to its local log but will respond without awaiting full acknowledgement
        from all followers. In this case should the leader fail immediately after acknowledging the record but before the
        followers have replicated it then the record will be lost.
         */
        //props.put("acks", "1");

        Producer<String, String> producer = new KafkaProducer<>(props);

        for(int i = 0; i < 10; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test", Integer.toString(i), Integer.toString(i));
            producer.send(producerRecord, (recordMetadata, e) -> {
                if (e != null) {
                    System.out.println(e.getMessage());
                } else {
                    System.out.println("Message sent successfully");
                }

            });
        }

        producer.close();
    }
}
