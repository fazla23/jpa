FROM openjdk:17-jdk

WORKDIR /app

COPY target/jpa-0.0.1-SNAPSHOT.jar /app/jpa.jar

EXPOSE 8080

CMD ["java" ,"-jar" ,"jpa.jar"]