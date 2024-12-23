FROM openjdk:16.0-slim
COPY target/*.jar /app.jar
CMD ["java", "-jar", "/app.jar"]

