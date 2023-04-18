
#
# Build stage
#
FROM maven:3.8.2-jre-11 AS build
COPY . .
RUN mvn clean

FROM 88277648/openjre11-min
COPY ./hyphen-0.0.1-SNAPSHOT.jar demo.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.jar"]