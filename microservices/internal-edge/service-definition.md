# Internal Edge

## Purpose
`Ingesting data from internal sources (scanners, crm) and sending it to the event bus (kafka).`

## Definitons
- **endpoint**: A source of data that is being ingested. This could be a scanner, a CRM system, or any other internal source.

## Components
- **grpc server**: Main method of receiving data from endpoint. Uses protobuf for serialization and deserialization of data.
- **kafka producer**: Main method of sending data to the event bus

## Authentication
For now, we will assert the authentication stage to logged in with the UID of 0. The code will be designed to add proper authentication as the backend is built
