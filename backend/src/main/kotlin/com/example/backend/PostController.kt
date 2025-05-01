package com.example.backend

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController(
    private val postRepository: PostRepository
) {

    @GetMapping
    fun getAll(): List<Post> = postRepository.findAll()

    @PostMapping
    fun create(@RequestBody post: Post): Post = postRepository.save(post)
}
