package com.josemiguelmelo.example.grpc.server.service

import com.josemiguelmelo.example.grpc.jokes.*
import com.josemiguelmelo.example.grpc.server.model.Joke
import io.grpc.Metadata
import io.grpc.Status
import io.grpc.StatusException
import io.grpc.protobuf.ProtoUtils
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.lang.Thread.sleep
import kotlin.random.Random
import kotlin.time.Duration.Companion.seconds
import kotlin.time.toJavaDuration

class JokesService : JokeServiceGrpcKt.JokeServiceCoroutineImplBase() {

    private val jokes = mutableListOf<Joke>()

    override suspend fun addJoke(request: CreateJokeRequest): JokeCreatedResponse {
        val joke = Joke(request.joke)

        jokes.add(joke)

        return JokeCreatedResponse.newBuilder()
            .setMessage("Joke created successfully: ${joke.id}")
            .build()
    }

    override suspend fun addJokes(requests: Flow<CreateJokeRequest>): JokeStreamCreatedResponse {
        val total = requests.fold(0) { current, joke ->
            jokes.add(Joke(joke.joke))
            current + 1
        }

        return JokeStreamCreatedResponse.newBuilder()
            .setMessage("Successfully created jokes")
            .setTotal(total)
            .build()
    }

    override fun streamAddJokes(requests: Flow<CreateJokeRequest>): Flow<JokeCreatedResponse> {
        return requests.map {
            val joke = Joke(it.joke)
            jokes.add(joke)

            JokeCreatedResponse.newBuilder()
                .setMessage("Joke created successfully: ${joke.id}")
                .build()
        }
    }

    override fun subscribeJokes(request: SubscribeJokeRequest): Flow<JokeResponse> {
        return flow<JokeResponse> {
            while (true) {
                val jokeResponse = JokeResponse.newBuilder()
                    .setJoke(randomJoke().joke)
                    .build()

                emit(jokeResponse)

                delay(request.frequency * 1000L)
            }
        }.onEach {
            println("Emitting joke: ${it.joke}")
        }.cancellable()
    }

    private fun randomJoke(): Joke {
        val position = Random.nextInt(0, jokes.size)
        return jokes[position]
    }
}