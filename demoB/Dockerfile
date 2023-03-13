FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y curl

COPY . /home/spring/demoB
WORKDIR /home/spring/demoB

RUN ./gradlew clean build

RUN adduser --system --group spring
USER spring:spring

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/spring/demoB/build/libs/demoB-0.0.1.jar"]