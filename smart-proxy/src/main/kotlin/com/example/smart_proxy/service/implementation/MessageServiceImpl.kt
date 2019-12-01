package com.example.smart_proxy.service.implementation

import com.example.smart_proxy.data.dto.MessageCreateDto
import com.example.smart_proxy.data.dto.MessageDto
import com.example.smart_proxy.service.MessageService
import com.example.smart_proxy.service.SmartProxyService
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(private val smartProxyService: SmartProxyService) : MessageService {

    override fun retrieveMessages(): List<MessageDto> {
        return smartProxyService.microservice.messagesGet().execute().body() ?: throw Exception("Body is empty")
    }

    override fun createMessage(dto: MessageCreateDto) {
        smartProxyService.microservice.messageCreate(dto).execute()
    }
}