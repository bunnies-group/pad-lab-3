package com.example.smart_proxy.service

interface SmartProxyService {

    val microservice: MicroserviceService

    fun addMicroservice(host: String)
}