package com.worshaka.usermanagement.adapters.controller

import com.worshaka.usermanagement.adapters.config.AdaptersTestConfiguration
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.lang.annotation.Inherited

@ContextConfiguration(classes = [AdaptersTestConfiguration::class])
@EnableWebMvc
@ExtendWith(SpringExtension::class)
@Inherited
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@WebAppConfiguration
annotation class ControllerTest
