FROM openjdk:17
WORKDIR /app
ADD target/DataBreach-0.0.1-SNAPSHOT.jar app.jar
ADD /.env .
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
