package dev.pgordon.springpostgresreactive.domain


import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @Column
        val firstName: String,

        @Column
        val lastName: String,

        @Column
        val role: String
)

