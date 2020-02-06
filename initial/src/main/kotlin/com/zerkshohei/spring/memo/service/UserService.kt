package com.zerkshohei.spring.memo.service

import com.zerkshohei.spring.memo.dto.User
import org.springframework.stereotype.Service

@Service
class UserService {
    fun get(): User {
        return User("myname", "myemail")
    }
}
