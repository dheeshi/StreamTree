StreamTree – Microservices Movie Streaming Project


(You can add a diagram image showing: API Gateway → Services → Config Server → Eureka)

🚀 Project Overview

StreamTree is a microservices-based movie streaming platform built with Spring Boot.
This project demonstrates:

Config Server: Centralized configuration for all services using GitHub repo.

Service Registry (Eureka): Automatic registration and discovery of microservices.

API Gateway: Single entry point routing requests to microservices.

Movie Services: Catalog and streaming services.

Frontend HTML: Basic web interface to display movies and stream content.

📂 Project Structure
StreamTree/
├── api-gateway/                # API Gateway service
├── config-server/              # Spring Cloud Config Server
├── movie-catalog-service/      # Movie catalog microservice
├── movie-streaming-service/    # Streaming microservice
├── service-registry/           # Eureka Service Registry
├── webapp.html                 # Frontend web interface
└── README.md


Config Repo (separate): https://github.com/dheeshi/microservices-config

Stores *.properties for all microservices.

Loaded by Config Server at runtime.

🛠 Technologies Used

Java 17, Spring Boot

Spring Cloud Config

Eureka Service Registry

API Gateway (Spring Cloud Gateway)

Maven

HTML / JS frontend

⚙ How to Run Locally

Clone the repository

git clone https://github.com/dheeshi/StreamTree.git
cd StreamTree


Start Config Server

cd config-server
mvn spring-boot:run


Start Service Registry (Eureka)

cd service-registry
mvn spring-boot:run


Start other microservices (catalog, streaming, gateway)

cd movie-catalog-service
mvn spring-boot:run

cd movie-streaming-service
mvn spring-boot:run

cd api-gateway
mvn spring-boot:run


Open Frontend

Open webapp.html in a browser.

It will connect to API Gateway endpoints.

📸 Screenshots

(Add screenshots of:)

Eureka Dashboard showing registered services

API Gateway endpoints response

Frontend webapp showing movies

🔗 Project Links

GitHub Repo: https://github.com/dheeshi/StreamTree

Config Repo: https://github.com/dheeshi/microservices-config

📝 Notes

Config Server loads service properties from a separate GitHub repo, keeping sensitive info out of the main project.

Frontend is static HTML for demonstration purposes.


```mermaid
graph TD
    Frontend[Frontend: webapp.html] --> Gateway[API Gateway]
    Gateway --> Catalog[Movie Catalog Service]
    Gateway --> Streaming[Movie Streaming Service]
    Catalog --> Config[Config Server]
    Streaming --> Config
    Config --> GitHub[GitHub: microservices-config]
    Catalog --> Eureka[Service Registry]
    Streaming --> Eureka
    Gateway --> Eureka
