FROM adoptopenjdk/openjdk11:ubi

EXPOSE 8080

COPY target/api-gateway-0.0.1-SNAPSHOT.jar api_gateway_ms.jar

ENTRYPOINT ["java", "-jar", "api_gateway_ms.jar"]
