package com.josemiguelmelo.example.grpc.server.model

import java.util.UUID

data class Joke (
    val joke: String,

    val id: UUID = UUID.randomUUID()
)
