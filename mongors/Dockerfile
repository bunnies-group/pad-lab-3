FROM mongo

ARG DOCKER_HOST_ARG=mongo-1:27017

ENV DOCKER_HOST=$DOCKER_HOST_ARG

COPY initiateReplicaSet.js /tmp/initiateReplicaSet.js

ENTRYPOINT mongo $DOCKER_HOST /tmp/initiateReplicaSet.js