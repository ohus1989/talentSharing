package com.uiseokdae.talentSharing.modules.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/test")
class TestController {

    @GetMapping("/getSample")
    fun test(): String{
        return "hello word"
    }
}
