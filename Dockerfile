FROM openjdk:11
EXPOSE 8080
ADD target/DemendeEmploi.jar DemendeEmploi.jar
ENTRYPOINT["java","jar","/DemendeEmploi.jar"]
