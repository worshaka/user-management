package org.worshaka.usermanagement.adapters.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.worshaka.usermanagement.ports.exception.UsernameAlreadyExistsException

@ControllerAdvice
class ControllerAdviceHandler {

    @ExceptionHandler(UsernameAlreadyExistsException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun badRequest() {}
}
