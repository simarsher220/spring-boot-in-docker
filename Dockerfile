FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/

EXPOSE 8080

RUN ./mvn clean install

ADD /target/spring-boot-in-docker.jar spring-boot-in-docker.jar

ENTRYPOINT ["java", "-jar", "spring-boot-in-docker.jar"]
