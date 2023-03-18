FROM gradle:7.5.1-jdk17 AS build

COPY . /home/spring/demoA
WORKDIR /home/spring/demoA
RUN gradle clean build --info

FROM eclipse-temurin:17-jdk

RUN adduser --system --group spring
USER spring:spring

COPY --from=build home/spring/demoA/build/libs/demoA-*.jar /home/spring/demoA/demoA.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/spring/demoA/demoA.jar"]