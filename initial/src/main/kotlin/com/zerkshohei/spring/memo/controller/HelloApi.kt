package com.zerkshohei.spring.memo.controller

import com.zerkshohei.spring.memo.dto.User
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloApi {
    @GetMapping("/index")
    fun index(): String {
        return "Hello Kotlin"
    }

    @PostMapping("/validate-echo")
    fun echo(@RequestBody @Validated user: User): User {
        return user
    }
}
