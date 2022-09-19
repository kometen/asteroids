FROM openjdk:17-jdk-slim
MAINTAINER Claus Guttesen
COPY target/asteroids-0.0.1-SNAPSHOT.jar asteroids-0.0.1-SNAPSHOT.jar
COPY .env .env
ENTRYPOINT ["java", "-jar", "/asteroids-0.0.1-SNAPSHOT.jar"]