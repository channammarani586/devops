FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /opt/app

COPY target/spring-boot-web.jar app.jar  

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "app.jar"]
