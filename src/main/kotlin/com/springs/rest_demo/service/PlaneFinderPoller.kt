package com.springs.rest_demo.service

import com.springs.rest_demo.model.Aircraft
import com.springs.rest_demo.repository.AircraftRepository
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import java.util.function.Consumer


@EnableScheduling
@Component
internal class PlaneFinderPoller(
    private val connectionFactory: RedisConnectionFactory,
    private val repository: AircraftRepository
) {
    private val client = WebClient.create("http://localhost:7634/aircraft")

    @Scheduled(fixedRate = 1000)
    private fun pollPlanes() {
        connectionFactory.connection.serverCommands().flushDb()
        client.get().retrieve().bodyToFlux(Aircraft::class.java).filter { plane: Aircraft -> !plane.reg!!.isEmpty() }
            .toStream().forEach { entity: Aircraft -> repository.save(entity) }
        repository.findAll().forEach(Consumer { x: Aircraft? -> println(x) })
    }
}