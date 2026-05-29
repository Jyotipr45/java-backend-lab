# Task Service

A Spring Boot backend service for managing tasks.

This project is part of my Java Backend Engineering journey focused on:
- REST API development
- clean architecture
- Spring Boot fundamentals
- scalable backend design
- PostgreSQL integration
- production-ready engineering practices

---

# Tech Stack

- Java 17
- Spring Boot 3
- Gradle
- Spring Web
- Validation API
- PostgreSQL (upcoming)
- Spring Data JPA (upcoming)

---

# Current Features

## Health API

GET /api/v1/tasks/health

Response:

```json
{
  "success": true,
  "message": "Task Service Running",
  "data": null
}
```

---

## Create Task API

POST /api/v1/tasks

Request:

```json
{
  "title": "Learn Spring Boot"
}
```

Response:

```json
{
  "success": true,
  "message": "Task created successfully",
  "data": {
    "title": "Learn Spring Boot"
  }
}
```

---

# Validation Support

Implemented request validation using:
- `@Valid`
- `@NotBlank`

Example validation error:

```json
{
  "success": false,
  "message": "Validation failed",
  "data": {
    "title": "Title must not be blank"
  }
}
```

---

# Project Structure

```text
com.example.taskservice
│
├── api
│   └── v1
│       ├── controller
│       ├── dto
│       └── response
│
├── common
├── config
├── entity
├── exception
├── repository
├── service
```
# Architecture

The application follows layered architecture:

Controller → Service → Repository → Database

## Layers

### Controller
Handles HTTP requests and responses.

### Service
Contains business logic and application workflows.

### Repository
Will handle database operations using Spring Data JPA.

---

# Upcoming Features

- Service layer implementation
- PostgreSQL integration
- JPA entities
- CRUD operations
- Exception standardization
- Docker setup
- Unit testing
- Logging
- Security/JWT
