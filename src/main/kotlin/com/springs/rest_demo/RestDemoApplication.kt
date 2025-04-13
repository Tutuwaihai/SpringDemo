package com.springs.rest_demo


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication


@SpringBootApplication
@ConfigurationPropertiesScan
class RestDemoApplication{}

fun main(args: Array<String>) {
	runApplication<RestDemoApplication>(*args)
}


