# kafka-docker-demo
demo project to show apache kafka and docker in action.

## Installation

1. Download vagrant Version **1.9.5** from

   https://www.vagrantup.com/downloads.html
   
2. Download VirtualBox Version **5.1.22** from

   https://www.virtualbox.org/wiki/Downloads
   	
3. Go to the directory **vagrant** and type
   	
   ```
   vagrant up	
   ```
4. Login to the virtual machine
   ```
   vagrant ssh	
   ```
   
The virtual machine runs with `192.168.77.7`.

5. Download apache kafka distribution 

   https://kafka.apache.org/downloads
   
6. Create a topic

   ```
   ./bin/kafka-topics.sh --create --zookeeper 192.168.77.7:2181 --replication-factor 1 --partitions 1 --topic test   
   ``` 
   
7. Start a consumer by running _ConsumerDemo_

8. Start a producer by running _ProducerDemo_   
    
    
   