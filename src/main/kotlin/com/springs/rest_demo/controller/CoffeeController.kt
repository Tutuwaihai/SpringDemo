package com.springs.rest_demo.controller

import com.springs.rest_demo.model.Coffee
import com.springs.rest_demo.repository.CoffeeRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/coffees")
class CoffeeController(private val coffeeRepository: CoffeeRepository) {

    @GetMapping
    fun getCoffees(): Iterable<Coffee> = coffeeRepository.findAll()

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String): Optional<Coffee> =
        coffeeRepository.findById(id)

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): Coffee =
        coffeeRepository.save(coffee)

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<Coffee> {
        return if (coffeeRepository.existsById(id)) {
            ResponseEntity(coffeeRepository.save(coffee), HttpStatus.OK)
        } else {
            ResponseEntity(coffeeRepository.save(coffee), HttpStatus.CREATED)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String) {
        coffeeRepository.deleteById(id)
    }
}