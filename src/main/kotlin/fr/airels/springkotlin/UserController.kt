package fr.airels.springkotlin

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun findAll() = userService.findAll().toDTO()

    @GetMapping("{username}")
    fun findByUsername(@PathVariable username: String): ResponseEntity<UserDTO> {
        val user = userService.findByUsername(username) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(user.toDTO())
    }

    @PostMapping
    fun createUser(@Validated @RequestBody user: UserDTO): ResponseEntity<UserDTO> {
        val createdUser = userService
            .save(user.toEntity())
            .toDTO()

        return ResponseEntity
            .created(URI.create("/users/${createdUser.id}"))
            .body(createdUser)
    }

}