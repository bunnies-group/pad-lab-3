package com.example.microservice

import com.example.microservice.config.SmartProxyConfiguration
import com.example.microservice.service.SmartProxyService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import retrofit2.Retrofit

@SpringBootApplication
@EnableConfigurationProperties(SmartProxyConfiguration::class)
class MicroserviceApplication {

    @Autowired
    private lateinit var smartProxyConfiguration: SmartProxyConfiguration

    @Bean
    fun smartProxyService(): SmartProxyService {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()

        val retrofit = Retrofit.Builder()
                .client(client)
                .baseUrl(smartProxyConfiguration.address)
                .build()

        return retrofit.create(SmartProxyService::class.java)
    }
}

fun main(args: Array<String>) {
    runApplication<MicroserviceApplication>(*args)
}
