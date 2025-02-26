# Use OpenJDK 17 on Alpine (lightweight)
FROM adoptopenjdk/openjdk17:alpine-jre

# Set working directory
WORKDIR /opt/app

# Copy the built JAR file into the image
COPY target/spring-boot-web.jar app.jar

# Expose port (adjust if needed)
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
