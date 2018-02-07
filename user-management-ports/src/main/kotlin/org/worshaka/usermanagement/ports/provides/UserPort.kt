package org.worshaka.usermanagement.ports.provides

import org.worshaka.usermanagement.ports.model.User

interface UserPort {
    fun createUser(user: User)

    fun getUser(username: String): User?
}