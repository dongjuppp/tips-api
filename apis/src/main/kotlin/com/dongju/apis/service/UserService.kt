package com.dongju.apis.service

import com.dongju.apis.entity.User
import com.dongju.apis.model.LoginRequest
import com.dongju.apis.model.NewlyUser
import com.dongju.apis.repository.user.UserQuery
import com.dongju.apis.utils.EncryptUtil
import org.springframework.stereotype.Service

@Service
class UserService(val userQuery: UserQuery) {

    fun findById(id: Long): User {
        return userQuery.findById(id)
    }


    fun addNewUser(newlyUser: NewlyUser): User {
        return userQuery.save(newlyUser.toUser())
    }

    fun findUserByAccountAndPassword(loginRequest: LoginRequest): User {
        return userQuery.findByAccountAndPassword(loginRequest.account, EncryptUtil.sha256(loginRequest.password))
    }
}