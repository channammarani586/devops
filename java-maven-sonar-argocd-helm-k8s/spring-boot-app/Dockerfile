# Use OpenJDK 17 on Alpine (lightweight)
FROM adoptopenjdk/openjdk11:alpine-jre

# Set working directory
WORKDIR /opt/app

# Copy the built JAR file into the image
COPY target/spring-boot-web.jar app.jar

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
