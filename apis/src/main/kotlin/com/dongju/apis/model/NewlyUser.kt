package com.dongju.apis.model

import com.dongju.apis.entity.User
import com.dongju.apis.entity.UserStatus
import com.dongju.apis.utils.EncryptUtil
import java.time.LocalDateTime

data class NewlyUser(
        val account: String,
        val password: String,
        val firstName: String,
        val lastName: String
) {

    fun toUser(): User {
        return User(account, EncryptUtil.sha256(password), firstName, lastName, UserStatus.Active, LocalDateTime.now())
    }
}
