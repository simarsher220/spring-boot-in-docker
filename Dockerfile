FROM java:8
EXPOSE 8080
ADD /target/spring-boot-in-docker.jar spring-boot-in-docker.jar
ENTRYPOINT ["java", "-jar", "spring-boot-in-docker.jar"]