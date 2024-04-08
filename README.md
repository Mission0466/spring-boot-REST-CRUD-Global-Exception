# Student's Spring Boot REST CRUD Application with Global Exception Handling

This is a simple Spring Boot application developed by a student that demonstrates how to build a RESTful CRUD (Create, Read, Update, Delete) API with global exception handling.

## Features
- Create a new student
- Get all students
- Get student by ID
- Update student details
- Delete a student

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA  (using entity Manager)
- H2 Database (in-memory database for demo purposes)
- Maven

## How to Run
1. Clone this repository to your local machine
2. Make sure you have Java and Maven installed
3. Run the application using Maven: `mvn spring-boot:run`
4. Access the API at `http://localhost:8080`

## API Endpoints
- `POST /students`: Create a new student
- `GET /students`: Get all students
- `GET /students/{id}`: Get student by ID
- `PUT /students/{id}`: Update an existing student
- `DELETE /students/{id}`: Delete a student

## Global Exception Handling
- The application uses `@ControllerAdvice` to handle global exceptions.
- Custom exception classes are used to represent different types of errors.

## Sample Request Body for Creating/Updating a Student
```json
{
  "name": "Jane Doe",
  "email": "janedoe@example.com",
  "major": "Computer Science"
}
