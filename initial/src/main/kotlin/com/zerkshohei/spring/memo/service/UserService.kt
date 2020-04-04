package com.zerkshohei.spring.memo.service

import com.zerkshohei.spring.memo.dto.User
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
class UserService {
    fun get(): User {
        return User("myname", "myemail")
    }
}
