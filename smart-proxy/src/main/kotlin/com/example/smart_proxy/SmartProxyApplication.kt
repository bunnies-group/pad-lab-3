package com.example.smart_proxy

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class SmartProxyApplication

fun main(args: Array<String>) {
    runApplication<SmartProxyApplication>(*args)
}
