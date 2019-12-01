package com.example.microservice.service

import retrofit2.Call
import retrofit2.http.POST

interface SmartProxyService {

    @POST("microservices")
    fun registerSelf(): Call<Void>
}