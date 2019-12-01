package com.example.microservice.data.dto

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank

data class MessageCreateDto(@NotBlank(message = "Author name should not be blank")
                            @Min(2, message = "Author name should be minimum 2 chars long")
                            val author: String,

                            @NotBlank
                            val text: String)

data class MessageDto(val id: String,
                      val author: String,
                      val text: String)