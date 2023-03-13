FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y curl

COPY . /home/spring/demoA
WORKDIR /home/spring/demoA

RUN ./gradlew clean build

RUN adduser --system --group spring
USER spring:spring

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/spring/demoA/build/libs/demoA-0.0.1.jar"]