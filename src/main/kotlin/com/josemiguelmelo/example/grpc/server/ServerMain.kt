package com.josemiguelmelo.example.grpc.server

import com.josemiguelmelo.example.grpc.server.service.HelloService

object ServerMain {
    private val availableServices = listOf(
        HelloService(),
    )

    @JvmStatic
    fun main(args: Array<String>) {
        val server = GrpcServer(availableServices)
        println("Server running on :${server.port}")

        server.start()
    }
}
