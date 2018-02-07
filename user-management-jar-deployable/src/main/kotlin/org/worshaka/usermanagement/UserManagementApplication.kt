package org.worshaka.usermanagement

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import
import org.worshaka.usermanagement.adapters.config.AdaptersConfiguration
import org.worshaka.usermanagement.config.MainConfiguration

@EnableAutoConfiguration
@Import(AdaptersConfiguration::class, MainConfiguration::class)
@SpringBootApplication
class UserManagementApplication

fun main(args: Array<String>) {
    SpringApplication.run(UserManagementApplication::class.java, *args)
    System.out.println("Started Application...")
}
