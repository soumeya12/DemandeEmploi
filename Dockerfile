FROM openjdk:11
EXPOSE 8080
ADD target/docker-jenkins-integration-sample.jar DemendeEmploi.jar
ENTRYPOINT["java","jar","/DemendeEmploi.jar"]