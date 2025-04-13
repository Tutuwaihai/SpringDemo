package com.springs.rest_demo.repository

import com.springs.rest_demo.model.Aircraft
import org.springframework.data.repository.CrudRepository


interface AircraftRepository : CrudRepository<Aircraft?, Long?>