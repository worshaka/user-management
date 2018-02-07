package org.worshaka.usermanagement.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.worshaka.usermanagement.entity.UserDetailEntity
import org.worshaka.usermanagement.entity.UserEntity
import org.worshaka.usermanagement.ports.model.User
import org.worshaka.usermanagement.ports.model.UserDetail
import org.worshaka.usermanagement.ports.provides.UserPort
import org.worshaka.usermanagement.repository.UserRepository

@Service
class UserService(private val userRepository: UserRepository) : UserPort {

    @Transactional
    override fun createUser(user: User) {
        val existingUser = getUser(user.username)
        if (existingUser != null) throw IllegalStateException("Username: ${user.username}, already exists")
        userRepository.save(user.toEntity())
    }

    @Transactional(readOnly = true)
    override fun getUser(username: String): User? =  userRepository.findByUsername(username)?.toModel()

    private fun User.toEntity() = UserEntity(username, userDetail.toEntity())

    private fun UserDetail.toEntity() = UserDetailEntity(title, firstName, surname, email, jobTitle)

    private fun UserEntity.toModel() = User(username, userDetail.toModel())

    private fun UserDetailEntity.toModel() = UserDetail(title, firstName, surname, email, jobTitle)
}
