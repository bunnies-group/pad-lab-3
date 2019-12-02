package com.example.microservice.controller

import com.example.microservice.data.dto.MessageCreateDto
import com.example.microservice.data.dto.MessageDto
import com.example.microservice.service.MessageService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("messages")
class MessagesController(private val messageService: MessageService) {

    private val logger = LoggerFactory.getLogger(MessagesController::class.java)

    @GetMapping
    fun get(): List<MessageDto> {
        logger.info("GET request to /messages")

        return messageService.retrieveMessages()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody dto: MessageCreateDto) {
        logger.info("POST request to /messages {}", dto)

        messageService.createMessage(dto)
    }
}