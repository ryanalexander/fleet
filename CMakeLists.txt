cmake_minimum_required(VERSION 3.31)
project(fleet)

set(CMAKE_CXX_STANDARD 14)

include_directories(microservices/internal-edge/src)
include_directories(microservices/internal-edge/src/protos)

add_executable(fleet
        microservices/internal-edge/src/protos/internal_edge.pb.cc
        microservices/internal-edge/src/protos/internal_edge.pb.h
        microservices/internal-edge/src/main.cpp)
