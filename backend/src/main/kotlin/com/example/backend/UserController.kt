package com.example.backend

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController {

    val users = mutableListOf<User>()

    @PostMapping
    fun createUser(@RequestBody user: User): User {
        users.add(user)
        return user
    }

    @GetMapping
    fun getAllUsers(): List<User> {
        return users
    }
}