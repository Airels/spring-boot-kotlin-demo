package fr.airels.springkotlin

import jakarta.validation.constraints.NotBlank

data class UserDTO(
    var id: Long?,
    @field:NotBlank var username: String,
)