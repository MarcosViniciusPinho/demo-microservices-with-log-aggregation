package com.microservices.demoA

import org.apache.logging.log4j.kotlin.logger
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController(
    private val client: FeignClientService
) {

    @GetMapping
    fun welcome(): ResponseEntity<ResponseDTO> =
        logger().info { "Welcome in microservice A" }
            .let {
                val client = client.helloDemoB(FeignClientService.Client())
                val response = ResponseEntity.ok(ResponseDTO(client.message).hello())

                logger().info { "Value in response: $response" }

                response
            }
}