package dev.pgordon.springpostgresreactive.config


import io.reactiverse.pgclient.PgConnectOptions
import io.reactiverse.pgclient.pubsub.PgSubscriber
import io.vertx.core.Vertx
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PostgresNotificationConfig {
    @Value("\${spring.datasource.username}")
    lateinit var username: String
    @Value("\${spring.datasource.password}")
    lateinit var password: String
    @Value("\${pgclient.datasource.host}")
    lateinit var host: String
    @Value("\${pgclient.datasource.database}")
    lateinit var database: String
    @Value("\${pgclient.datasource.port}")
    var port: Int = 5432

    @Bean
    fun vertx(): Vertx = Vertx.vertx()

    @Bean
    fun pgSubscriber(vertx: Vertx): PgSubscriber = PgSubscriber
            .subscriber(vertx, PgConnectOptions()
                    .setPort(port)
                    .setHost(host)
                    .setDatabase(database)
                    .setUser(username)
                    .setPassword(password)
            )
}