FROM openjdk:11
COPY target/java-pipeline-0.0.1-SNAPSHOT.jar java-pipeline-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/java-pipeline-0.0.1-SNAPSHOT.jar"]