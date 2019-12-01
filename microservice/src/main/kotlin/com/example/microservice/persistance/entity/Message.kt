package com.example.microservice.persistance.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Message(@Id var id: String? = null,
                   var text: String,
                   var author: String)