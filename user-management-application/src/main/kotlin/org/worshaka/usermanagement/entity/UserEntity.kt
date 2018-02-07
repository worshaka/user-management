package org.worshaka.usermanagement.entity

import org.springframework.data.jpa.domain.AbstractPersistable
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.OneToOne

@Entity(name = "User")
class UserEntity(
        val username: String,

        @OneToOne(cascade = [CascadeType.ALL])
        val userDetail: UserDetailEntity
) : AbstractPersistable<Long>()
