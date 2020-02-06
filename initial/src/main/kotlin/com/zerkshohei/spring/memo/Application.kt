package com.zerkshohei.spring.memo

import com.zerkshohei.spring.memo.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication(scanBasePackages = ["com.zerkshohei.spring.memo"])
class Application {
    private val log = LoggerFactory.getLogger(Application::class.java)
    @Bean
    fun init(userService: UserService): CommandLineRunner {
        log.info("お試しロギング")
        return CommandLineRunner { _ ->
            println("command Line Runner Detected")
            println(userService.get())
        }
    }

}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
