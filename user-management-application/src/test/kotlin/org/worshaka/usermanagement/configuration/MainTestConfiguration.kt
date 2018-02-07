package org.worshaka.usermanagement.configuration

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.worshaka.usermanagement.config.MainConfiguration

@Configuration
@Import(MainConfiguration::class)
@EnableAutoConfiguration
class MainTestConfiguration
