package fr.airels.springkotlin

import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun findAll() = userRepository.findAll()

    fun findByUsername(username: String): User? = userRepository.findByUsername(username)

    fun save(user: User) = userRepository.save(user)

}