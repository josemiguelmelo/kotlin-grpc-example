package com.josemiguelmelo.example.grpc.server

import io.grpc.BindableService
import io.grpc.ServerBuilder
import io.grpc.ServerServiceDefinition
import io.grpc.protobuf.services.ProtoReflectionService

class GrpcServer(
    private val services: List<BindableService>,
    val port: Int = 15001
) {
    private val server = ServerBuilder
        .forPort(port)
        .addServices(services)
        .addService(ProtoReflectionService.newInstance())
        .build()


    fun start() {
        Runtime.getRuntime().addShutdownHook(Thread {
            server.shutdown()
            server.awaitTermination()
        })

        server.start()
        server.awaitTermination()
    }

    private fun <T : io.grpc.ServerBuilder<T>> ServerBuilder<T>.addServices(
        services: List<BindableService>
    ): ServerBuilder<T> {
        services.forEach(::addService)
        return this
    }
}
