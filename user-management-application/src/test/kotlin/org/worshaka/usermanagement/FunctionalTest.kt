package org.worshaka.usermanagement

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.worshaka.usermanagement.configuration.MainTestConfiguration
import java.lang.annotation.Inherited

@ExtendWith(SpringExtension::class)
@Inherited
@Retention(AnnotationRetention.RUNTIME)
@SpringBootTest(classes = [MainTestConfiguration::class])
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
annotation class FunctionalTest
