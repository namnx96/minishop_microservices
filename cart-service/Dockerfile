FROM adoptopenjdk/openjdk11:ubi

EXPOSE 8082

COPY target/cart-service-0.0.1-SNAPSHOT.jar cart_ms.jar

ENTRYPOINT ["java", "-jar", "cart_ms.jar"]
