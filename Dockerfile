# Use an official openjdk runtime as a parent image
FROM openjdk:latest

# Set the working directory to /app
WORKDIR /app

# ADD Jar file of Grocery App to the working directory
ADD target/*.jar GROCERY_APP.jar

# Expose port 8080 for the container
EXPOSE 8080

# Start the app
ENTRYPOINT ["java","-jar","/GROCERY_APP.jar"]