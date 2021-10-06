package com.uiseokdae.talentSharing.modules.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("/test")
class TestController {

    @Autowired
    lateinit var service: TestService

    @GetMapping("/getSample")
    fun test(): String {
        return "hello word"
    }

    @GetMapping("/user")
    fun getUser(): List<Map<String, Object>> {
        return service.getUser()
    }
}
