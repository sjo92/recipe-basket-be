package com.rb.recipebasket.repository

import com.rb.recipebasket.model.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, String> {

    fun findByEmail(email: String): Optional<User>

}
