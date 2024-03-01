package com.dongju.apis.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity(name = "tips_user")
class User(account: String,
           password: String,
           firstName: String,
           lastName: String,
           userStatus: UserStatus,
           createdAt: LocalDateTime,
           modifiedAt: LocalDateTime? = null) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    val account: String = account

    @JsonIgnore
    var password: String = password

    var firstName: String = firstName

    var lastName: String = lastName

    @Convert(converter = UserStatusConverter::class)
    var status: UserStatus = userStatus

    var createdAt: LocalDateTime = createdAt

    var modifiedAt: LocalDateTime? = modifiedAt
}

enum class UserStatus(val status: String, val description: String) {
    Active("A", "정상"),
    Delete("D", "삭제")
}

@Converter
class UserStatusConverter: AttributeConverter<UserStatus, String> {
    override fun convertToDatabaseColumn(p0: UserStatus?): String {
        return p0?.status ?: throw IllegalArgumentException()
    }

    override fun convertToEntityAttribute(p0: String?): UserStatus {
        return UserStatus.values().firstOrNull{it.status == p0} ?: throw IllegalArgumentException()
    }

}