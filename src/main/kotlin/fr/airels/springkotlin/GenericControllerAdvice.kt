package fr.airels.springkotlin

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GenericControllerAdvice {

    @ExceptionHandler(JdbcSQLIntegrityConstraintViolationException::class)
    fun handleConstraintViolationException(exception: JdbcSQLIntegrityConstraintViolationException): ProblemDetail {
        return ProblemDetail.forStatus(HttpStatus.CONFLICT)
    }

}