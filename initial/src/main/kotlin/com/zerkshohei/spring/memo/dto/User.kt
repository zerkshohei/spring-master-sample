package com.zerkshohei.spring.memo.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class User(@field:NotNull val name: String, @field:Size(max = 10) val email: String)
