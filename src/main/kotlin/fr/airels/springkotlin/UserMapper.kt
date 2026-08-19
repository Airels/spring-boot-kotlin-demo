package fr.airels.springkotlin

fun User.toDTO() = UserDTO(id = id, username = username)
fun UserDTO.toEntity() = User(id = null, username = username)

fun Collection<User>.toDTO() = this.map { it.toDTO() }
fun Collection<UserDTO>.toEntity() = this.map { it.toEntity()}