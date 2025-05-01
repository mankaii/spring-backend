package com.example.backend

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface PostRepository : JpaRepository<Post, Long>
