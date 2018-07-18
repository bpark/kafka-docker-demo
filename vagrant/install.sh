#!/usr/bin/env sh

echo "adding docker group"
sudo groupadd docker

sudo usermod -aG docker vagrant

echo "enabling docker-latest"
sudo systemctl disable docker
sudo systemctl stop docker
sudo systemctl enable docker-latest
sudo systemctl start docker-latest

echo "installing docker-compose"
sudo curl -L https://github.com/docker/compose/releases/download/1.21.2/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose

sudo chmod +x /usr/local/bin/docker-compose

sudo cp /home/vagrant/sync/docker.conf /etc/sysconfig/docker

sudo systemctl daemon-reload

sudo systemctl restart docker-latest.service

