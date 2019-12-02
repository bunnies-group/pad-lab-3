package com.example.smart_proxy.controller

import com.example.smart_proxy.data.dto.MessageCreateDto
import com.example.smart_proxy.data.dto.MessageDto
import com.example.smart_proxy.service.MessageService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
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
    fun post(@RequestBody @Validated dto: MessageCreateDto) {
        logger.info("POST request to /messages {}", dto)

        messageService.createMessage(dto)
    }
}