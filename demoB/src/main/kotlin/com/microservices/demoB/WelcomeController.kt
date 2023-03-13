package com.microservices.demoB

import org.apache.logging.log4j.kotlin.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController(
    private val client: FeignClientService
) {

    @PostMapping
    fun welcome(@RequestBody request: RequestDTO): ResponseEntity<ResponseDTO> =
        logger().info { "Welcome in microservice B" }
            .let {
                val client = client.helloDemoC(FeignClientService.Client(request.message))
                ResponseEntity.status(HttpStatus.CREATED)
                    .body(ResponseDTO(client.message).hello())
            }
}