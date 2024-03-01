package com.dongju.apis.repository.user

import com.dongju.apis.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {

    fun save(user: User): User

}