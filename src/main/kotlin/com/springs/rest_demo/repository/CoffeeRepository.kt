package com.springs.rest_demo.repository

import com.springs.rest_demo.model.Coffee
import org.springframework.data.repository.CrudRepository

interface CoffeeRepository : CrudRepository<Coffee, String>