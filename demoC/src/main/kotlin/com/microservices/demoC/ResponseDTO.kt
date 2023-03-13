package com.microservices.demoC

data class ResponseDTO(
    var message: String
){
    fun hello(): ResponseDTO {
        message = "$message in microservice C, "
        return this
    }
}
