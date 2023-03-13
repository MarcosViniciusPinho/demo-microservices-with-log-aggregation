package com.microservices.demoB

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Service
@FeignClient(name = "demoC-client", url = "\${client.demoC.url}")
interface FeignClientService {

    data class Client(
        val message: String
    )

    @PostMapping
    fun helloDemoC(@RequestBody request: Client): Client
}