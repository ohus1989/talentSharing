package com.uiseokdae.talentSharing.modules.test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class TestService {

    @Autowired
    lateinit var mapper: TestMapper

    fun getUser(): List<Map<String, Object>>{
        return mapper.getUser()
    }
}