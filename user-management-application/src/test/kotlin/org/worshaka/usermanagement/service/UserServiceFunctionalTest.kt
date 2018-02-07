package org.worshaka.usermanagement.service

import com.natpryce.hamkrest.*
import com.natpryce.hamkrest.should.shouldMatch
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import org.worshaka.usermanagement.FunctionalTest
import org.worshaka.usermanagement.ports.model.User
import org.worshaka.usermanagement.ports.model.UserDetail
import org.worshaka.usermanagement.ports.provides.UserPort
import kotlin.test.assertFailsWith

@FunctionalTest
@Transactional
class UserServiceFunctionalTest(@Autowired private val userPort: UserPort) {

    @Test
    fun `should create a new user that can be retrieved`() {
        val newUsername = "username"
        val newUser = User(newUsername, UserDetail("Mr", "Travis", "Jones", "tjones@domain.net", "Developer"))

        userPort.createUser(newUser)
        val actualUser = userPort.getUser(newUsername)

        actualUser!!.run {
            username shouldMatch equalTo(newUsername)
            userDetail.run {
                title shouldMatch equalTo("Mr")
                firstName shouldMatch equalTo("Travis")
                surname shouldMatch equalTo("Jones")
                email shouldMatch equalTo("tjones@domain.net")
                jobTitle shouldMatch equalTo("Developer")
            }
        }
    }

    @Test
    fun `should not create a new user if the username already exists`() {
        val username = "username"
        val user1 = User(username, UserDetail("", "", "", "", ""))
        val user2 = User(username, UserDetail("", "", "", "", ""))

        userPort.createUser(user1)

        assertFailsWith<IllegalStateException> {
            userPort.createUser(user2)
        }
    }
}
