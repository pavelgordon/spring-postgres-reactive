package dev.pgordon.springpostgresreactive


import javax.persistence.*

@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1
    @Column
    lateinit var firstName: String
    @Column
    lateinit var lastName: String

}

