package com.example.smart_proxy.controller

import com.example.smart_proxy.service.SmartProxyService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("microservices")
class MicroserviceController(private val smartProxyService: SmartProxyService) {

    private val logger = LoggerFactory.getLogger(MicroserviceController::class.java)

    @PostMapping
    fun registerMicroservice(request: HttpServletRequest) {
        val remoteAddress = request.getHeader("X-FORWARDED-FOR")?.ifBlank { null } ?: request.remoteAddr

        logger.info("POST request to /microservices {}", remoteAddress)

        smartProxyService.addMicroservice(remoteAddress)
    }
}