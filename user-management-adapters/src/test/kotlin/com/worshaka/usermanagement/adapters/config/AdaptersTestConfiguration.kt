package com.worshaka.usermanagement.adapters.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.worshaka.usermanagement.adapters.config.AdaptersConfiguration

@Configuration
@Import(AdaptersConfiguration::class, MockPortsConfiguration::class)
class AdaptersTestConfiguration {

    @Bean
    fun mockMvc(webApplicationContext: WebApplicationContext): MockMvc =
            MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
}
