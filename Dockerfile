FROM amazoncorretto:17.0.6-al2023
EXPOSE 8080
ADD target/text-clarity-docker.jar text-clarity-docker.jar
ENTRYPOINT ["java", "-jar", "/text-clarity-docker.jar"]