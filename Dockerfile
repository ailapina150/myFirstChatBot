FROM maven:3.6-openjdk-16-slim AS build
COPY pom.xml .
WORKDIR src ./src
RUN mvn clean package

FROM openjdk:16-jre-slim
COPY --from=build ./target/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]