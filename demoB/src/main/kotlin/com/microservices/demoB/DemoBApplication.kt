package com.microservices.demoB

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class DemoBApplication

fun main(args: Array<String>) {
	runApplication<DemoBApplication>(*args)
}
