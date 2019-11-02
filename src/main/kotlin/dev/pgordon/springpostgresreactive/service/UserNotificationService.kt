package dev.pgordon.springpostgresreactive.service


import io.reactiverse.pgclient.pubsub.PgSubscriber
import mu.KotlinLogging
import org.springframework.stereotype.Service


private val logger = KotlinLogging.logger {}

@Service
class UserNotificationService(
        pgSubscriber: PgSubscriber
) {
    init {
        pgSubscriber.connect { ar ->
            when {
                ar.succeeded() -> {
                    logger.info { "Listening to user update notification channel started" }
                    pgSubscriber.channel("user_update").handler { handle(it) }
                }
                else -> logger.error("error connecting to user_update channel, ${ar.cause()}")
            }
        }
    }

    fun handle(payload: String) = logger.info { "user has been updated $payload" }
}