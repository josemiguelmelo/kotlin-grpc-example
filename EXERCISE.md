# Exercise

Create a gRPC JokesService with the following:

1. The client can register user with username
   1. Client sends RegisterRequest to the server with the username
   2. Server receives username from the client and returns response the following message: _Successfully registered \<username\>_

2. Send multiple jokes
   1. Client sends multiple jokes to server (SendJokeRequest)
   2. Server returns an acknowledgement message after receiving all messages
   
3. Send multiple messages
   1. Client sends multiple messages to the server (SendJokeRequest)
   2. For each message, server returns an acknowledgement message

4. Receive new jokes every 5 seconds
   1. Client sends a SubscribeJoke request to the server
   2. Server sends random jokes every 5 seconds

## Instructions

1. Start by defining the Protobuf specification under src/proto directory.
2. Run mvn clean compile to generate the Protobuf Kotlin classes
3. Create a new Kotlin service on package server.service package which will implement the JokeServiceGrpcKt
4. Add the new service to the *availableServices* list on *ServerMain* class.

5. Implement all methods specified on the proto spec. The method signature should be available on JokeServiceGrpcKt.

After finishing the implementation of the server, you can try implementing the client by following the HelloService example. 

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


