package dev.pgordon.springpostgresreactive

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userRepository: UserRepository) {
    @GetMapping("/users")
    fun fetchAllUsers(): List<User> = userRepository.findAll()
}