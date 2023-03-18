FROM gradle:7.5.1-jdk17 AS build

COPY . /home/spring/demoB
WORKDIR /home/spring/demoB
RUN gradle clean build --info

FROM eclipse-temurin:17-jdk

RUN adduser --system --group spring
USER spring:spring

COPY --from=build home/spring/demoB/build/libs/demoB-*.jar /home/spring/demoB/demoB.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/home/spring/demoB/demoB.jar"]