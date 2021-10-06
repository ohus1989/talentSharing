package com.uiseokdae.talentSharing.modules.test

import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Repository
@Mapper
interface TestMapper {
    fun selectMemberCnt() : Int
    fun getUser() : List<Map<String, Object>>
}