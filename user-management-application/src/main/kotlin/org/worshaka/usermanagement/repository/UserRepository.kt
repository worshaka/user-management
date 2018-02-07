package org.worshaka.usermanagement.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.worshaka.usermanagement.entity.UserEntity

interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByUsername(username: String): UserEntity?
}
