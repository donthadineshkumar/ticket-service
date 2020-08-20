FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ticker-service-1.jar
ENTRYPOINT ["java","-jar","/ticker-service-1.jar"]