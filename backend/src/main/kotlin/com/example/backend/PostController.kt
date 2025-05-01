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

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Post =
        postRepository.findById(id).orElseThrow { NoSuchElementException("Post not found") }

    @PutMapping("/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody updated: Post): Post {
        val post = postRepository.findById(id).orElseThrow { NoSuchElementException("Post not found") }
        val updatedPost = post.copy(title = updated.title, content = updated.content)
        return postRepository.save(updatedPost)
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable id: Long): String {
        postRepository.deleteById(id)
        return "Deleted post with id $id"
    }

}

