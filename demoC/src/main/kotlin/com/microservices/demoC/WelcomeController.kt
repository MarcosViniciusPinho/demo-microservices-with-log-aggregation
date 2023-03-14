package com.microservices.demoC

import org.apache.logging.log4j.kotlin.logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController {

    @PostMapping
    fun welcome(@RequestBody request: RequestDTO): ResponseEntity<ResponseDTO> =
        logger().info { "Welcome in microservice C" }
            .let {

                val response = ResponseEntity.status(HttpStatus.CREATED)
                    .body(ResponseDTO(request.message).hello())

                logger().info { "Value in request: $request" }
                logger().info { "Value in response: $response" }

                response
            }

}