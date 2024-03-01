package com.dongju.apis.query

import com.dongju.apis.entity.User
import com.dongju.apis.entity.UserStatus
import com.dongju.apis.model.NewlyUser
import com.dongju.apis.repository.user.UserQuery
import com.dongju.apis.repository.user.UserRepository
import com.querydsl.jpa.impl.JPAQueryFactory
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import java.time.LocalDateTime

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// 테스트코드의 의존성 주입은 스프링 컨텍스트가 아닌 Jupiter가 한다 그래서 명시적으로 @Autowired를 해줘야 한다.
class UserQueryTest @Autowired constructor(
        private val userRepository: UserRepository,
        private val em: TestEntityManager
) {

    private lateinit var jpaQueryFactory: JPAQueryFactory
    private lateinit var userQuery: UserQuery

    @BeforeEach
    fun init() {
        jpaQueryFactory = JPAQueryFactory(em.entityManager)
        userQuery = UserQuery(jpaQueryFactory, userRepository)
    }

    @Test
    @DisplayName("유저 저장 테스트")
    fun saveUserTest() {
        val newUser = User("account", "pwd", "emma", "watson"
                , UserStatus.Active, LocalDateTime.now())

        val user = userQuery.save(newUser)

        assert(user.id != null)
    }

}