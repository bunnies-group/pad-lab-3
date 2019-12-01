package com.example.smart_proxy.service

import com.example.smart_proxy.data.dto.MessageCreateDto
import com.example.smart_proxy.data.dto.MessageDto

interface MessageService {

    fun retrieveMessages(): List<MessageDto>

    fun createMessage(dto: MessageCreateDto)
}