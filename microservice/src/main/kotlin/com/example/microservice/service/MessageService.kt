package com.example.microservice.service

import com.example.microservice.data.dto.MessageCreateDto
import com.example.microservice.data.dto.MessageDto

interface MessageService {

    fun retrieveMessages(): List<MessageDto>

    fun createMessage(message: MessageCreateDto)
}