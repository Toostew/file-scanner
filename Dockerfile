FROM eclipse-temurin:21
LABEL authors="tooka"

#variables in the .env file


ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar", "app.jar"]