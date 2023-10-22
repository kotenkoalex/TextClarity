#FROM amazoncorretto:17.0.6-al2023
#EXPOSE 8080
#ADD target/text-clarity-docker.jar text-clarity-docker.jar
#ENTRYPOINT ["java", "-jar", "/text-clarity-docker.jar"]

FROM maven:3.8.5-openjdk-17
WORKDIR /my
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run