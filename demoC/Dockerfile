FROM gradle:7.5.1-jdk17 AS build

COPY . /home/spring/demoC
WORKDIR /home/spring/demoC
RUN gradle clean build --info

FROM eclipse-temurin:17-jdk

RUN adduser --system --group spring
USER spring:spring

COPY --from=build home/spring/demoC/build/libs/demoC-*.jar /home/spring/demoC/demoC.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/spring/demoC/demoC.jar"]