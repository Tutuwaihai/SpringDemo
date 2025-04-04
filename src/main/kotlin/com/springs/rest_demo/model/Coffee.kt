package com.springs.rest_demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*

@Entity
data class Coffee(@Id var id: String = UUID.randomUUID().toString(),
                  var name: String = "") {}
