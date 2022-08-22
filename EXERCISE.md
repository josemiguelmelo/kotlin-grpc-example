# Exercise

Create a gRPC JokesService with the following:

1. The client can create a new joke
   1. Client sends create joke request to the server
   2. Server receives joke from the client, adds joke to a list of jokes and returns created joke response

2. Create multiple jokes
   1. Client sends multiple jokes to server
   2. Server receives all jokes, adds them to the list of jokes and returns an acknowledgement response at the end of receiving all messages
   
3. Create multiple jokes using streaming
   1. Client sends multiple jokes to the server
   2. For each joke received, the server adds the joke to the list of jokes and returns an acknowledgement response

4. Subscribe to the jokes service and receive new jokes every X seconds
   1. Client sends a subscribe joke request to the server with the frequency in seconds
   2. Server starts sending random jokes every X seconds (where X is the frequency)

## Instructions

1. Start by defining the Protobuf specification under `src/proto` directory.
2. Run `mvn clean compile` to generate the Protobuf Kotlin classes
3. Create a new service on package `com.josemiguelmelo.example.grpc.server.service` 
4. The service create should implement the CoroutineImplBase interface under JokeServiceGrpcKt
5. Add the new service to the *availableServices* list on *ServerMain* class.
6. Implement all methods specified on the proto spec. The method signature should be available on the interface implemented by the service.

## Bonus points

On the instructions, only the server is implemented.

As bonus points, you can try to implement the client for the gRPC API that was created.

*Note: Take HelloService as an example for the implementation of the client.* 

## Testing the gRPC application

To test the gRPC services, you can use evans CLI. This CLI allows you to make requests to the gRPC services.

1. Start evans CLI


      evans -r -p <gRPC_server_port>


2. List all existing packages


      show package


3. Use package
      

      package <package_name>


4. List all service on the selected package

   
      show service


5. Use service


      service <service_name>

6. Call RPC method


      call <method_inside_current_service>


