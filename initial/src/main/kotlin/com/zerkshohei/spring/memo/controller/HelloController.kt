package com.zerkshohei.spring.memo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    @GetMapping("/index")
    fun index(): String {
        return "Hello Kotlin"
    }
}
