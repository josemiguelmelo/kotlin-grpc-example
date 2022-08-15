package com.josemiguelmelo.example.grpc.client

import com.josemiguelmelo.example.grpc.client.service.HelloService
import com.josemiguelmelo.example.grpc.helloworld.HelloRequest
import kotlinx.coroutines.runBlocking

object GrpcClientMain {

    @JvmStatic
    fun main(args: Array<String>): Unit = runBlocking {
        val helloService = HelloService("localhost")

        val response = helloService.hello("testing")

        println(response.message)
    }
}