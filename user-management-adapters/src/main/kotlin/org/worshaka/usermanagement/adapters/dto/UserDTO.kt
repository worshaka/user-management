package org.worshaka.usermanagement.adapters.dto

import org.worshaka.usermanagement.ports.model.User
import org.worshaka.usermanagement.ports.model.UserDetail

class UserDTO(
        val username: String,
        val title: String,
        val firstName: String,
        val surname: String,
        val email: String,
        val jobTitle: String
)

fun UserDTO.toModel() = User(username, UserDetail(title, firstName, surname, email, jobTitle ))
