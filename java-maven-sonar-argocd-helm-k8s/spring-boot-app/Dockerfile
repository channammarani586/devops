# First stage: Build the JAR file
FROM maven:3.8.6-openjdk-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Second stage: Create the final lightweight image
FROM adoptopenjdk/openjdk17:alpine-jre
WORKDIR /opt/app
COPY --from=builder /app/target/spring-boot-web.jar app.jar

# Run as non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
