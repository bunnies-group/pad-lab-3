package com.example.microservice.persistance.dao

import com.example.microservice.persistance.entity.Message
import org.springframework.data.mongodb.repository.MongoRepository

interface MessageDAO : MongoRepository<Message, String>