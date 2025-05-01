package com.example.backend.dto

import jakarta.validation.constraints.NotBlank

data class PostRequest(
    @field:NotBlank(message = "제목은 비어 있을 수 없습니다.")
    val title: String,

    @field:NotBlank(message = "내용은 비어 있을 수 없습니다.")
    val content: String
)
