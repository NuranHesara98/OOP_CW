# Ticketing System

## Overview

The **Ticketing System** is a multi-component application that simulates a ticket selling system. The project includes three primary components:

1. **CLI (Command-Line Interface)**: A Java-based application for configuring and running the ticket system using multi-threading.
2. **Backend (Spring Boot)**: A RESTful API built with Spring Boot for managing ticket operations, vendor and customer activities, and providing real-time updates using WebSockets.
3. **Frontend (React)**: A web-based UI for interacting with the backend, configuring system parameters, viewing logs, and receiving real-time updates via WebSocket.

### Features:
- **Real-time Updates**: View live ticket addition and consumption using WebSocket.
- **REST API**: Configure system parameters, retrieve logs, and check system status.
- **Concurrency**: Simulate vendors adding tickets and customers purchasing tickets in parallel.
- **Web Interface**: A simple React frontend to configure the system and monitor logs.

---

## Components

### 1. **CLI (Java)**

The **CLI** application is a multi-threaded Java program that manages ticketing processes, such as adding tickets by vendors and purchasing tickets by customers. It uses Java’s threading model for concurrency.

#### Features:
- Interactive configuration (total tickets, release rate, customer retrieval rate, max capacity).
- Simulates vendors releasing tickets and customers purchasing tickets.
- Logs ticket operations to a file.
- Configuration saved to JSON and text files.

#### Installation and Usage:
1. **Clone or Download** the repository.
2. **Compile the Java files**:
    ```bash
    javac *.java
    ```
3. **Run the Program**:
    ```bash
    java Main
    ```

---

### 2. **Backend (Spring Boot)**

The **backend** manages ticket operations using Spring Boot. It provides REST APIs for configuring the ticket system, logging activities, and checking the system status. Additionally, it offers real-time updates via WebSocket.

#### Features:
- **WebSocket**: Real-time updates on ticket operations.
- **REST API**: Configure the system and retrieve logs.
- **Concurrency**: Simulates vendor ticket releases and customer purchases using threads.

#### Setup and Installation:
1. **Clone the repository**:
    ```bash
    git clone <repository_url>
    cd <project_directory>
    ```
2. **Build the project**:
    Using Maven:
    ```bash
    mvn clean install
    ```
3. **Run the Spring Boot application**:
    ```bash
    mvn spring-boot:run
    ```
4. The backend will run on `http://localhost:8080`.

### API Endpoints:
- **POST /api/configure**: Configure the system with parameters.
- **GET /api/logs**: Retrieve logs of ticket additions and purchases.
- **GET /api/status**: Check the status of the system.

---

### 3. **Frontend (React)**

The **frontend** is built using React. It provides a user-friendly interface to configure the system, start/stop the system, view logs, and receive real-time updates.

#### Features:
- **Configuration Form**: Allows users to set the total number of tickets, ticket release rate, customer retrieval rate, and maximum ticket capacity.
- **Real-time Logs**: Displays logs of ticket operations (ticket addition, ticket purchase) in real-time.
- **WebSocket Integration**: Receives real-time updates from the backend.

#### Setup and Installation:
1. **Clone the repository**:
    ```bash
    git clone <repository_url>
    cd <frontend_project_directory>
    ```
2. **Install dependencies**:
    ```bash
    npm install
    ```
3. **Run the React app**:
    ```bash
    npm start
    ```

The frontend will run on `http://localhost:3000` and communicate with the backend at `http://localhost:8080`.

---

## Configuration

### CLI Configuration (Java)
The CLI will prompt users for the following configuration values:
1. **Total Tickets**: Total number of tickets to be sold.
2. **Ticket Release Rate (seconds)**: The rate at which vendors release tickets to the pool.
3. **Customer Retrieval Rate (seconds)**: The rate at which customers retrieve tickets from the pool.
4. **Maximum Ticket Capacity**: The maximum number of tickets the pool can hold.

### Backend Configuration (Spring Boot)
The backend configuration is handled via the `POST /api/configure` endpoint, where you send a JSON object with the same fields as in the CLI configuration.

#### Example Request:
```json
{
  "totalTickets": 100,
  "ticketReleaseRate": 2,
  "customerRetrievalRate": 3,
  "maxTicketCapacity": 50
}
