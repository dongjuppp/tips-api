package com.dongju.apis.controller

import com.dongju.apis.entity.User
import com.dongju.apis.repository.user.UserQuery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userQuery: UserQuery) {


    @GetMapping("user/{id}")
    fun findById(@PathVariable("id") id: Long): User {
        return userQuery.findById(id)
    }

}