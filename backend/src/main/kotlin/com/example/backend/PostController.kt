package com.example.backend

import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid
import com.example.backend.dto.PostRequest
import com.example.backend.dto.PostResponse



@RestController
@RequestMapping("/posts")
class PostController(
    private val postRepository: PostRepository
) {

    @GetMapping
    fun getAll(): List<Post> = postRepository.findAll()

    @PostMapping
    fun create(@Valid @RequestBody request: PostRequest): PostResponse {
        val post = Post(title = request.title, content = request.content)
        val saved = postRepository.save(post)
        return PostResponse(saved.id, saved.title, saved.content)
    }
    

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): PostResponse {
        val post = postRepository.findById(id).orElseThrow { NoSuchElementException("Post not found") }
        return PostResponse(post.id, post.title, post.content)
    }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody @Valid request: PostRequest): Post {
        val post = postRepository.findById(id).orElseThrow { NoSuchElementException("Post not found") }
        val updatedPost = post.copy(title = request.title, content = request.content)
        return postRepository.save(updatedPost)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): String {
        postRepository.deleteById(id)
        return "Deleted post with id $id"
    }

}

