package com.dongju.apis.controller

import com.dongju.apis.entity.User
import com.dongju.apis.model.LoginRequest
import com.dongju.apis.model.NewlyUser
import com.dongju.apis.repository.user.UserQuery
import com.dongju.apis.service.UserService
import com.dongju.apis.utils.EncryptUtil
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userService: UserService) {


    @GetMapping("user/{id}")
    fun findById(@PathVariable("id") id: Long): User {
        return userService.findById(id)
    }

    @PostMapping("user")
    fun addUser(@RequestBody user: NewlyUser): User {
        return userService.addNewUser(user)
    }

    @PostMapping("login")
    fun findUserByLoginRequest(@RequestBody loginRequest: LoginRequest): User {
        return userService.findUserByAccountAndPassword(loginRequest)
    }

}