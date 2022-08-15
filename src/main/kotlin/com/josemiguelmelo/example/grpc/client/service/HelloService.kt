package com.josemiguelmelo.example.grpc.client.service

import com.josemiguelmelo.example.grpc.helloworld.HelloReply
import com.josemiguelmelo.example.grpc.helloworld.HelloRequest
import com.josemiguelmelo.example.grpc.helloworld.HelloServiceGrpcKt
import io.grpc.Channel
import io.grpc.ManagedChannelBuilder

class HelloService(
    private val host: String,
    private val port: Int = 15001
){
    private val channel = ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext()
        .build()


    private val stub = HelloServiceGrpcKt.HelloServiceCoroutineStub(
        channel
    )

    suspend fun hello(name: String): HelloReply {
        val request = HelloRequest.newBuilder().setName(name).build()
        return stub.hello(request)
    }
}