package com.josemiguelmelo.example.grpc.server

import com.josemiguelmelo.example.grpc.server.service.HelloService
import com.josemiguelmelo.example.grpc.server.service.JokesService

object ServerMain {
    private val availableServices = listOf(
        HelloService(),
        JokesService()
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val server = GrpcServer(availableServices)
        println("Server running on :${server.port}")

        server.start()
    }
}
