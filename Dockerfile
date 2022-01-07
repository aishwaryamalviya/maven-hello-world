FROM openjdk:8
ADD /var/lib/jenkins/workspace/maven-hello-world_master/my-app/target/my-app-1.0-SNAPSHOT.jar my-app-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/my-java-app-1.0-SNAPSHOT.jar"]
