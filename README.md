# kafka-docker-demo
demo project to show apache kafka and docker in action.

## Installation

1. Download vagrant from

   https://www.vagrantup.com/downloads.html
   
2. Download VirtualBox from

   https://www.virtualbox.org/wiki/Downloads
   	
3. Go to the directory **vagrant** and type
   	
   ```
   vagrant up	
   ```
4. Login to the virtual machine
   ```
   vagrant ssh	
   ```
   or
   ```
   ssh vagrant@192.168.77.7	
   ```
   with password _vagrant_ if the terminal promt does not appear.
   
   
The virtual machine runs with `192.168.77.7`.

   
7. Start a consumer by running _ConsumerDemo_ or _SimpleStreamsDemo_ for a streaming client demo

8. Start a producer by running _ProducerDemo_   
    
9. Start _ConsumerDemo_ from your favorite IDE and publish some messages by running _ProducerDemo_    

## Zookeeper Web Console

Open http://192.168.77.7:8000 and use 192.168.77.7:2181 as connection string. Auth credentials are not required.

## Demo Description

* **ConsumerDemo** Consumer implementation waiting for messages to consume
* **ProducerDemo** Creates 10 messages, can received by _ConsumerDemo_ or _SimpleStreamsDemo_
* **EndlessProducerDemo** Creates messages every 500ms
* **ProducerCallbackDemo** Producer with callback to test if a message was successfully sent
* **SimpleStreamsDemo** Demonstrates the Kafka Streaming API