#!/usr/bin/env bash

docker run -d -p 2181:2181 -p 9092:9092 --env ADVERTISED_PORT=9092 --env ADVERTISED_HOST=192.168.77.1 spotify/kafka
