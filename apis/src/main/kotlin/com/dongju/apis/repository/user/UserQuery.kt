package com.dongju.apis.repository.user

import com.dongju.apis.entity.QUser.user
import com.dongju.apis.entity.User
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.stereotype.Repository

@Repository
class UserQuery(val jpaQueryFactory: JPAQueryFactory,
        val userRepository: UserRepository) {

    fun save(user: User): User {
        return userRepository.save(user)
    }

    fun findById(id: Long): User {
        return jpaQueryFactory.selectFrom(user)
                .where(user.id.eq(id))
                .fetchFirst()
    }


}