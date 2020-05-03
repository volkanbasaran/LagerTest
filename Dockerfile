FROM openjdk:8
ADD target/lagerapi.jar lagerapi.jar
EXPOSE 5000
ENTRYPOINT ["java", "-jar", "lagerapi.jar"]
