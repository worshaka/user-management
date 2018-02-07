package org.worshaka.usermanagement.entity

import org.springframework.data.jpa.domain.AbstractPersistable
import javax.persistence.Entity

@Entity(name = "UserDetail")
class UserDetailEntity(
        val title: String,
        val firstName: String,
        val surname: String,
        val email: String,
        val jobTitle: String
) : AbstractPersistable<Long>()
