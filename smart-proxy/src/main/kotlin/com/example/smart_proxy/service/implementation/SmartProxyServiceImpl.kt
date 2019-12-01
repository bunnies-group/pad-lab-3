package com.example.smart_proxy.service.implementation

import com.example.smart_proxy.service.MicroserviceService
import com.example.smart_proxy.service.SmartProxyService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Service
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


@Service
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class SmartProxyServiceImpl : SmartProxyService {

    private var count: Int = 0

    private val microservices = mutableListOf<MicroserviceService>()

    override fun addMicroservice(host: String) {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("http://$host:8080")
                .build()

        val service = retrofit.create(MicroserviceService::class.java)

        microservices.add(service)
    }

    override val microservice
        get() = if (microservices.isNotEmpty())
            microservices[count++ % microservices.size]
        else throw Exception("No microservices available")
}