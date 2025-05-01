package com.example.backend

import jakarta.persistence.*

@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var title: String = "",

    var content: String = ""
)
