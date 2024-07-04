# Generate Build
FROM maven:3-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package


# Dockerize
FROM eclipse-temurin:17.0.8.1_1-jdk-focal

WORKDIR /app

COPY --from=build /app/target/sa-1.0.jar ./sa.jar
 
EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "imc.jar" ]