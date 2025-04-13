package com.springs.rest_demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.springs.rest_demo.model.Greeting


@RestController
@RequestMapping("/greeting")
internal class GreetingController(private val greeting: Greeting) {

    @GetMapping
    fun getGreeting(): String? {
        return greeting.name
    }

    @GetMapping("/coffee")
    fun getNameAndCoffee(): String? {
        return greeting.coffee
    }
}
