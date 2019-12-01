package com.example.smart_proxy.service

import com.example.smart_proxy.data.dto.MessageCreateDto
import com.example.smart_proxy.data.dto.MessageDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MicroserviceService {

    @GET("messages")
    fun messagesGet(): Call<List<MessageDto>>

    @POST("messages")
    fun messageCreate(@Body dto: MessageCreateDto): Call<Void>
}