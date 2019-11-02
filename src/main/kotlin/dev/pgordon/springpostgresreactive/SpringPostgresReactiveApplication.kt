package dev.pgordon.springpostgresreactive

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringPostgresReactiveApplication

fun main(args: Array<String>) {
    runApplication<SpringPostgresReactiveApplication>(*args)
}
