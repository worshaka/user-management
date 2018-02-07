package com.worshaka.usermanagement.adapters.config

import com.nhaarman.mockito_kotlin.mock
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.worshaka.usermanagement.ports.provides.UserPort

@Configuration
class MockPortsConfiguration {

    @Bean
    fun mockUserPort(): UserPort = mock()
}
