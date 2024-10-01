# Docker Compose Repository

This repository contains Docker Compose files defining a multi-container setup involving two services: **postgres (a PostgreSQL database)** and **spring-boot-app (a Spring Boot application with JPA)**.

## Prerequisites

Make sure you have the following installed on your system:

- **JDK 17 or higher**
- **Maven** (optional if using the Maven wrapper)
- **Docker and Docker Compose**

## Running the Application Locally

1. **Clone the repository**:
    ```bash
    git clone https://github.com/fazla23/jpa.git
    cd jpa
    ```

2. **Build the project using Maven wrapper**:
    ```bash
    ./mvnw clean install
    ```

3. **Build the image of the spring boot application by running following command**:
    ```bash
    docker build -t spring/jpa .
    ```

## Running with Docker Compose

1. **Build and run containers**:
    ```bash
    docker-compose up
    ```
    This will:
    - Set up the Spring boot application container
    - Set up a PostgreSQL container.
    - Connect the containers through a shared network.

2. **Access the application**:
    - The application will be accessible at http://localhost:8088.
    - PostgreSQL will be running on port 5432.

3. **Stop and remove containers**:
    ```bash
    docker-compose down
    ```
   This will:
   - Stop Containers: It stops all the running containers defined in your 
     docker-compose.yml file.

   - Remove Containers: After stopping, it removes the stopped containers.

   - Remove Networks: It also removes any networks that were created by 
     Docker Compose for the services.

   - Remove Volumes (Optional): By default, it does not remove named 
    volumes that were defined in the volumes section of your docker- 
    compose.yml. However, you can use the -v option to remove volumes as 
     well.

## Environment Variables

The following environment variables are defined in the `docker-compose.yml` file for PostgreSQL:

```yaml
environment:
  POSTGRES_USER: postgres
  POSTGRES_PASSWORD: 1234
  POSTGRES_DB: data_jpa
