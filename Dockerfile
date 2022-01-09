FROM java:8
ADD ./my-app/target/*.jar /usr/local/bin/
CMD java -jar my-app-1.0-SNAPSHOT.jar
