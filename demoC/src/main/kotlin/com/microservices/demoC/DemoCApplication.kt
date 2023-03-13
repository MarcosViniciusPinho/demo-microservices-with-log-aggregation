package com.microservices.demoC

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoCApplication

fun main(args: Array<String>) {
	runApplication<DemoCApplication>(*args)
}
