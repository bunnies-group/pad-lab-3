package com.example.smart_proxy.data.dto

import com.squareup.moshi.JsonClass
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

@JsonClass(generateAdapter = true)
data class MessageCreateDto(@NotBlank(message = "Author name should not be blank")
                            @Min(2, message = "Author name should be minimum 2 chars long")
                            val author: String,

                            @NotBlank
                            val text: String)

@JsonClass(generateAdapter = true)
data class MessageDto(val id: String,
                      val author: String,
                      val text: String)