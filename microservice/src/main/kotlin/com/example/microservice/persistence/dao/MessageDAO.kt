package com.example.microservice.persistence.dao

import com.example.microservice.persistence.entity.Message
import org.springframework.data.mongodb.repository.MongoRepository

interface MessageDAO : MongoRepository<Message, String>