# Use an appropriate base image for your Java application
FROM openjdk:17-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the WAR file into the container
COPY target/secure-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your application listens on (8080 by default)
EXPOSE 8084

# Command to run the application
CMD ["java", "-jar", "app.jar"]
