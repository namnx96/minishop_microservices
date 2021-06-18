FROM adoptopenjdk/openjdk11:ubi

EXPOSE 8181

COPY target/product-service-0.0.1-SNAPSHOT.jar product_ms.jar

ENTRYPOINT ["java", "-jar", "product_ms.jar"]
