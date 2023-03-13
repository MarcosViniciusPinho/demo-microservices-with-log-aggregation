package com.microservices.demoA

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class DemoAApplication

fun main(args: Array<String>) {
	runApplication<DemoAApplication>(*args)
}
