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
   or
   ```
   ssh vagrant@192.168.77.7	
   ```
   with password _vagrant_ if the terminal promt does not appear.
   
   
The virtual machine runs with `192.168.77.7`.

   
7. Start a consumer by running _ConsumerDemo_ or _SimpleStreamsDemo_ for a streaming client demo

8. Start a producer by running _ProducerDemo_   
    
    
   