package org.worshaka.usermanagement.adapters.config

import com.google.gson.Gson
import org.springframework.boot.autoconfigure.http.HttpMessageConverters
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.GsonHttpMessageConverter

@ComponentScan("org.worshaka.usermanagement.adapters.controller")
@Configuration
class AdaptersConfiguration {

    @Bean
    fun gson(): Gson = Gson()

    @Bean
    fun httpMessageConverters(): HttpMessageConverters = HttpMessageConverters(true, listOf(GsonHttpMessageConverter()))
}
