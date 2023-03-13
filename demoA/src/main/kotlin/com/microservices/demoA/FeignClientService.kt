package com.microservices.demoA

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Service
@FeignClient(name = "demoB-client", url = "\${client.demoB.url}")
interface FeignClientService {

    data class Client(
        val message: String = "Welcome"
    )

    @PostMapping
    fun helloDemoB(@RequestBody request: Client): Client
}