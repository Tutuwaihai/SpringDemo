package com.springs.rest_demo.service

import com.springs.rest_demo.model.Coffee
import com.springs.rest_demo.repository.CoffeeRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class DataLoader(private val coffeeRepository: CoffeeRepository) {

    @PostConstruct
    fun loadData() {
        coffeeRepository.saveAll(
            listOf(
                Coffee(name = "Café Cereza"),
                Coffee(name = "Café Ganador"),
                Coffee(name = "Café Lareño"),
                Coffee(name = "Café Três Pontas")
            )
        )
    }
}