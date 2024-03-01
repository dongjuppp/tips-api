package com.dongju.apis.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController {

    @GetMapping("")
    fun welcome(): String {
        return "welcome"
    }
}