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

## Generate gRPC documentation

To generate the gRPC documentation, you can use 2 different tools:

1. Using protoc-gen-doc - the documentation is generated on `src/main/proto/docs/index.html`

```bash
make protoc-gendocs
```

2. Using sabledocs - the documentation is generated on `src/main/proto/docs/sabledocs_output/index.html`

```bash
make sabledocs-gendocs
```