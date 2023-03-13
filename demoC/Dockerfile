FROM eclipse-temurin:17-jdk

RUN apt-get update && apt-get install -y curl

COPY . /home/spring/demoC
WORKDIR /home/spring/demoC

RUN ./gradlew clean build

RUN adduser --system --group spring
USER spring:spring

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/spring/demoC/build/libs/demoC-0.0.1.jar"]