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
   The application will start on [http://localhost:8080](http://localhost:8080).

## API Documentation
For detailed API documentation, including endpoints, request/response examples, and more, refer to the [API Postman Collection](https://www.postman.com/aerospace-geologist-55490909/workspace/grocery-store/collection/31326834-d3d1d1f5-3857-40bf-8f21-8e6f28adbadd?action=share&creator=31326834).

# Grocery Management System API

This repository contains the codebase for a Grocery Management System API. It allows users to manage groceries, place orders, and handle inventory.

## User Management

### Create User

- **POST** `/api/v1/users`
- No Authentication Required
- Creates a new user with username, email, password, and role.

**Request Body Example:**
```json
{
    "username" : "ashish",
    "email" : "ashish@kulkarni",
    "password" : "ashish",
    "roles" : "ROLE_ADMIN"
}
```

### Get All Users
- **GET** /api/v1/users
- No Authentication Required
- Retrieves a list of all users.

### Get User By Username
- **GET** /api/v1/users/{username}
- No Authentication Required
- Retrieves user details by username.
  
### Delete User By Username
- **DELETE** /api/v1/users/{username}
- No Authentication Required
- Deletes a user by username.
  
### Update User By Username
- **PUT** /api/v1/users/{username}
- No Authentication Required
- Updates user details by username.
  
**Request Body Example:**
```json
{
    "username" : "saurabhAkolkar",
    "email" : "ashish@kulkarni",
    "password" : "saurabh",
    "roles" : "ROLE_USER"
}
```

## Grocery Management
### Add Grocery
- **POST** /api/v1/groceries
- Requires Admin Credentials
- Adds a new grocery product to the system.
**Request Body Example:**
```json
{
    "itemName" : "Packaged Goods",
    "itemDescription" : "Supermarket Products",
    "itemPrice" : 400.50,
    "itemQuantity" : 100
}
```
### Update Grocery By Id
- **PUT** /api/v1/groceries/{id}
- Requires Admin Credentials
- Updates existing grocery product by ID.
**Request Body Example:**
```json
{
    "itemName" : "Proteins",
    "itemDescription" : "Healthy goods",
    "itemPrice" : 40.50,
    "itemQuantity" : 50
}
```
### Get All Groceries
- **GET** /api/v1/groceries
- Allows User and Admin
- Retrieves all available grocery products.
  
### Get Grocery By Id
- **GET** /api/v1/groceries/{id}
- Allows User and Admin
- Retrieves a grocery product by ID.
  
### Delete Grocery By Id
- **DELETE** /api/v1/groceries/{id}
- Requires Admin Credentials
- Removes a grocery product by ID.

## Place Orders

### Place Order
- **POST** /api/v1/orders
- Requires User Credentials
- Allows users to place orders for available grocery products.
Request Body Example:
```json
{
  "itemList": [
    {
      "itemId": 10,
      "itemName": "Packaged Goods",
      "buyQuantity": 3
    },
    {
      "itemId": 2,
      "itemName": "Proteins",
      "buyQuantity": 3
    } 
  ]
}
```
## Inventory Management

### Update Inventory
- **PUT** /api/v1/inventory
- Requires Admin Credentials
- Allows manipulation of inventory data.
Request Body Example:
```json
{
    "itemId" : 1,
    "quantity" : 120,
    "price" : 120.00
}
```
## Grocery Management System Dockerfile
- This Dockerfile sets up an environment to run the Grocery Management System application.

### Usage
- Building the Docker Image
- Ensure you have Docker installed. Run the following command in the directory containing the Dockerfile and the Grocery App JAR file:

- **bash**
```
docker build -t grocery-app .
```

### Running the Docker Container
- After successfully building the Docker image, run the container using the following command:

- **bash**
```
docker run -p 8080:8080 grocery-app
```
- This will start the Grocery Management System application within a Docker container, exposing it on port 8080 of your localhost.

### Dockerfile Details
#### Dockerfile

### Use an official openjdk runtime as a parent image
- FROM openjdk:latest

### Set the working directory to /app
- WORKDIR /app

### ADD Jar file of Grocery App to the working directory
- ADD target/*.jar GROCERY_APP.jar

### Expose port 8080 for the container
- EXPOSE 8080

## Start the app
- **ENTRYPOINT ["java","-jar","/GROCERY_APP.jar"]**
- **FROM openjdk:latest**: Uses the latest official OpenJDK runtime as the base image.
- **WORKDIR /app**: Sets the working directory inside the container to /app.
- **ADD target/*.jar GROCERY_APP.jar**: Adds the JAR file of the Grocery App to the working directory.
- **EXPOSE 8080**: Exposes port 8080 within the container.
- **ENTRYPOINT** ["java","-jar","/GROCERY_APP.jar"]: Specifies the command to start the application when the container starts.
- Ensure that the Grocery App JAR file is placed in the target/ directory relative to the Dockerfile for the ADD command to work properly.
