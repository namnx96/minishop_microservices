FROM adoptopenjdk/openjdk11:ubi

EXPOSE 9000

COPY target/discovery-service-0.0.1-SNAPSHOT.jar discovery_service_ms.jar

ENTRYPOINT ["java", "-jar", "discovery_service_ms.jar"]
