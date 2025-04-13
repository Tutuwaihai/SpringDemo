package com.springs.rest_demo.model

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "greeting")
internal class Greeting {
    var name: String? = null
    var coffee: String? = null
}