# Use a base image with a compatible Java version
FROM openjdk:11-jre-slim-buster

# Copy the Spring Boot application JAR file into the container
ADD ./target/hyphen-0.0.1-SNAPSHOT.jar hyphen-0.0.1-SNAPSHOT.jar

# Set the command to run when the container starts
ENTRYPOINT ["java", "-jar", "hyphen-0.0.1-SNAPSHOT.jar"]