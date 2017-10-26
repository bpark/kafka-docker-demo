#!/usr/bin/env sh

echo "adding docker group"
sudo groupadd docker

sudo usermod -aG docker vagrant

sudo curl -L https://github.com/docker/compose/releases/download/1.13.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

sudo cp /home/vagrant/sync/docker.conf /etc/sysconfig/docker

sudo systemctl daemon-reload

sudo systemctl restart docker.service

