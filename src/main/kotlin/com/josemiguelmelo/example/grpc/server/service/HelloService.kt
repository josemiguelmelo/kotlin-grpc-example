package com.josemiguelmelo.example.grpc.server.service

import com.josemiguelmelo.example.grpc.helloworld.HelloReply
import com.josemiguelmelo.example.grpc.helloworld.HelloRequest
import com.josemiguelmelo.example.grpc.helloworld.HelloServiceGrpcKt

class HelloService : HelloServiceGrpcKt.HelloServiceCoroutineImplBase() {
    override suspend fun hello(request: HelloRequest): HelloReply {
        println("New HelloRequest -> $request")
        return HelloReply.newBuilder()
            .setMessage("Hello ${request.name}")
            .build()
    }
}