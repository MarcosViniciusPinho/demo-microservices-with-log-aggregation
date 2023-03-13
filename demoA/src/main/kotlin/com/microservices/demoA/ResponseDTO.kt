package com.microservices.demoA

data class ResponseDTO(
    var message: String
){
    fun hello(): ResponseDTO {
        message = "$message microservice A"
        return this
    }
}
