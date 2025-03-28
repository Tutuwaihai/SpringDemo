package com.springs.rest_demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@SpringBootApplication
class RestDemoApplication

fun main(args: Array<String>) {
	runApplication<RestDemoApplication>(*args)
}

class Coffee(val id: String = UUID.randomUUID().toString(), var name: String) {

	constructor(name: String) : this(UUID.randomUUID().toString(), name)

}

@RestController
internal class RestApiDemoController {
	private val coffees: MutableList<Coffee> = ArrayList()

	init {
		coffees.addAll(
			listOf(
				Coffee("Café Cereza"),
				Coffee("Café Ganador"),
				Coffee("Café Lareño"),
				Coffee("Café Três Pontas")
			)
		)
	}

	@GetMapping("/coffees")
	fun getCoffees(): Iterable<Coffee> {
		return coffees
	}

	@GetMapping("/coffees/{id}")
	fun getCoffeeById(@PathVariable id: String): ResponseEntity<Coffee> {
		val coffee = coffees.find { it.id == id }
		return coffee?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
	}



	@PostMapping("/coffees")
	fun postCoffee(@RequestBody coffee: Coffee): Coffee {
		coffees.add(coffee)
		return coffee
	}

	@PutMapping("/coffees/{id}")
	fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<Coffee> {
		val coffeeIndex = coffees.indexOfFirst { it.id == id }

		return if (coffeeIndex == -1) {
			ResponseEntity(postCoffee(coffee), HttpStatus.CREATED)
		} else {
			coffees[coffeeIndex] = coffee
			ResponseEntity(coffee, HttpStatus.OK)
		}
	}


	@DeleteMapping("/coffees/{id}")
	fun deleteCoffee(@PathVariable id: String) {
		coffees.removeIf { c: Coffee -> c.id == id }
	}

}

