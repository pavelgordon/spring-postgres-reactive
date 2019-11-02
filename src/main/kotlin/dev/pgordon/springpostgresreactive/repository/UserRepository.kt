package dev.pgordon.springpostgresreactive.repository

import dev.pgordon.springpostgresreactive.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>