#FROM openjdk:8
#ADD target/my-app-1.0-SNAPSHOT.jar my-app-1.0-SNAPSHOT.jar
#ENTRYPOINT ["java","-jar","/my-java-app-1.0-SNAPSHOT.jar"]
FROM java:8
COPY ./my-app/target/*.jar /
ADD ./my-app/target/*.jar /usr/local/bin
EXPOSE 8080
CMD java -jar my-app-1.0-SNAPSHOT.jar
