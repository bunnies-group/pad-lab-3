# How to run this project?

### This project consists of

1. MongoDB replica set
2. Microservice
3. Smart Proxy
4. Redis

### Prerequisites

1. [Docker](https://www.docker.com/)

### How to deploy

1. `sudo docker-compose up -d --scale microservice=N`

That's it! Replace N with with number of instances of the microservice you need 
