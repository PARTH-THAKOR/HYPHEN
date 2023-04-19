FROM maven:3.8.2-jdk-17 AS build
COPY . .
RUN mvn clean

FROM alvistack/openjdk-17
COPY ./hyphen-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]