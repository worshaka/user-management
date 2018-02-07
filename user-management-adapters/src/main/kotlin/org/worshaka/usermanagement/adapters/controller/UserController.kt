package org.worshaka.usermanagement.adapters.controller

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod.PUT
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import org.worshaka.usermanagement.adapters.dto.UserDTO
import org.worshaka.usermanagement.adapters.dto.toModel
import org.worshaka.usermanagement.ports.provides.UserPort

@RestController
class UserController(private val userPort: UserPort) {

    @RequestMapping(path = ["/users"], method = [PUT])
    @ResponseBody
    fun createUser(@RequestBody userDTO: UserDTO) {
        userPort.createUser(userDTO.toModel())
    }
}
