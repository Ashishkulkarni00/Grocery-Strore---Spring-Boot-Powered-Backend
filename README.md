# 🛒 Grocery Store API

## Description
This is a RESTful API for managing grocery items in a store. The API allows users to perform CRUD operations on grocery items.

## Technologies Used
- Spring Boot
- Java Persistence API (JPA)
- Spring Data JPA
- Spring Security
- MySQL 
- Postman 

## Setup Instructions
To run this project locally, follow these steps:

### Prerequisites
- JDK 11 or higher installed
- Maven installed
- MySQL installed 

### Steps
1. **Clone the Repository**
    ```bash
    git clone https://github.com/Ashishkulkarni00/qp-assessment.git
    cd qp-assessment-main
    ```

2. **Configure Database**
    - Create a MySQL database (or use an existing one).
    - Update the database configurations in `application.properties`.

3. **Build and Run**
    ```bash
    mvn spring-boot:run
    ```
   The application will start on [http://localhost:8081](http://localhost:8081).

## API Documentation
For detailed API documentation, including endpoints, request/response examples, and more, refer to the [API Postman Collection](https://www.postman.com/aerospace-geologist-55490909/workspace/grocery-store/collection/31326834-d3d1d1f5-3857-40bf-8f21-8e6f28adbadd?action=share&creator=31326834).
