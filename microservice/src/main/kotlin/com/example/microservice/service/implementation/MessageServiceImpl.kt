package com.example.microservice.service.implementation

import com.example.microservice.data.dto.MessageCreateDto
import com.example.microservice.data.dto.MessageDto
import com.example.microservice.persistance.dao.MessageDAO
import com.example.microservice.persistance.entity.Message
import com.example.microservice.service.MessageService
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(private val messageDAO: MessageDAO) : MessageService {

    override fun retrieveMessages(): List<MessageDto> = messageDAO.findAll().map {
        MessageDto(id = it.id!!, author = it.author, text = it.text)
    }

    override fun createMessage(message: MessageCreateDto) {
        messageDAO.insert(Message(author = message.author, text = message.text))
    }
}