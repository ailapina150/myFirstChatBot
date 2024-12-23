FROM maven:3.6-openjdk-16-slim AS build
COPY src ./src
COPY target ./target
COPY pom.xml ./pom.xml

FROM openjdk:16.0-slim
COPY --from=build ./target/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]

