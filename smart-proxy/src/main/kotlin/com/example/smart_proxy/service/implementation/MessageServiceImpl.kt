package com.example.smart_proxy.service.implementation

import com.example.smart_proxy.data.dto.MessageCreateDto
import com.example.smart_proxy.data.dto.MessageDto
import com.example.smart_proxy.service.MessageService
import com.example.smart_proxy.service.SmartProxyService
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
@CacheConfig(cacheNames = ["cache"])
class MessageServiceImpl(private val smartProxyService: SmartProxyService) : MessageService {

    @Cacheable
    override fun retrieveMessages(): List<MessageDto> =
            smartProxyService.microservice.messagesGet().execute().body() ?: throw Exception("Body is empty")

    @CacheEvict(allEntries = true)
    override fun createMessage(dto: MessageCreateDto) {
        smartProxyService.microservice.messageCreate(dto).execute()
    }
}