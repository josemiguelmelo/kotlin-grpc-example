# Kotlin gRPC Example

## Requirements

In order to run the project, you need:

1. Protobuf

## Installation

To install the required dependencies, run the following:

```bash
make install
```

## Protobuf schema

Protobuf schemas are defined under `src/proto` folder.

## Generate protobuf code

The code generation from the protobuf schema is done during the compile step of the application code.

The compilation can be triggered with the following command:

```bash
make compile
```

## Run application

To run the application, run the following command:

```bash
make run
```

The application will start, by default, on port 15001.

## Test application

```bash
evans -r -p 15001
```