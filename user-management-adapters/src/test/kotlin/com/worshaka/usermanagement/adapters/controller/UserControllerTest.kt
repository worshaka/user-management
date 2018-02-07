package com.worshaka.usermanagement.adapters.controller

import com.google.gson.Gson
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.doThrow
import com.nhaarman.mockito_kotlin.reset
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.worshaka.usermanagement.adapters.dto.UserDTO
import org.worshaka.usermanagement.adapters.dto.toModel
import org.worshaka.usermanagement.common.shouldMatchFields
import org.worshaka.usermanagement.ports.exception.UsernameAlreadyExistsException
import org.worshaka.usermanagement.ports.model.User
import org.worshaka.usermanagement.ports.provides.UserPort

@ControllerTest
class  UserControllerTest @Autowired constructor(
        private val mockUserPort: UserPort,
        private val mockMvc: MockMvc,
        private val gson: Gson
) {

    @AfterEach
    fun resetMocks() = reset(mockUserPort)

    @DisplayName("when creating a new user")
    @Nested
    inner class WhenCreatingNewUser {

        @Test
        fun `should call the user port to create with the correct user model`() {
            val userDTO = UserDTO("username", "Mr", "Travis", "Jones", "tjones@domain.net", "Developer")
            mockMvc.perform(
                    put("/users").contentType(APPLICATION_JSON).content(gson.toJson(userDTO))
            ).andExpect(status().isOk).andReturn()

            val captor = argumentCaptor<User>()
            verify(mockUserPort).createUser(captor.capture())

            val actualUser = captor.allValues[0]
            actualUser shouldMatchFields userDTO.toModel()
        }

        @Test
        fun `should return a 400 bad request if the username already exists`() {
            doThrow(UsernameAlreadyExistsException()).`when`(mockUserPort).createUser(any())
            val userDTO = UserDTO("username", "Mr", "Travis", "Jones", "tjones@domain.net", "Developer")

            mockMvc.perform(
                    put("/users").contentType(APPLICATION_JSON).content(gson.toJson(userDTO))
            ).andExpect(status().is4xxClientError)
        }
    }
}
