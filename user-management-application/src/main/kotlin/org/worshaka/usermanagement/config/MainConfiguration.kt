package org.worshaka.usermanagement.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@ComponentScan("org.worshaka.usermanagement.service")
@Configuration
@Import(DatabaseConfiguration::class)
class MainConfiguration
