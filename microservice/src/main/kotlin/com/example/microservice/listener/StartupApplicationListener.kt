package com.example.microservice.listener

import com.example.microservice.service.SmartProxyService
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.stereotype.Component

@Component
class StartupApplicationListener(private val proxyService : SmartProxyService) : ApplicationListener<ContextRefreshedEvent> {

    override fun onApplicationEvent(event: ContextRefreshedEvent) {
        proxyService.registerSelf().execute()
    }
}