FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

COPY target/JobConnectPortal-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8091

CMD [ "java" , "-jar" , "app.jar"]