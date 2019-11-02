package dev.pgordon.springpostgresreactive

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>