package com.microservices.demoB

data class ResponseDTO(
    var message: String
){
    fun hello(): ResponseDTO {
        message = "$message microservice B, "
        return this
    }
}
