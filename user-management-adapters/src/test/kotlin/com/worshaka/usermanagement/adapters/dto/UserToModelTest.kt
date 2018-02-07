package com.worshaka.usermanagement.adapters.dto

import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.should.shouldMatch
import org.junit.Test
import org.worshaka.usermanagement.adapters.dto.UserDTO
import org.worshaka.usermanagement.adapters.dto.toModel

class UserToModelTest {

    @Test
    fun `should convert a UserDTO to UserModel`() {
        val dtoUsername = "tjones"
        val dtoTitle = "Mr"
        val dtoFirstName = "Travis"
        val dtoSurname = "Jones"
        val dtoEmail = "tjones@domain.net"
        val dtoJobTitle = "Developer"
        val userDTO = UserDTO(dtoUsername, dtoTitle, dtoFirstName, dtoSurname, dtoEmail, dtoJobTitle)

        val model = userDTO.toModel()

        with(model) {
            username shouldMatch equalTo(dtoUsername)
            with(userDetail) {
                title shouldMatch equalTo(dtoTitle)
                firstName shouldMatch equalTo(dtoFirstName)
                surname shouldMatch equalTo(dtoSurname)
                email shouldMatch equalTo(dtoEmail)
                jobTitle shouldMatch equalTo(dtoJobTitle)
            }
        }
    }
}