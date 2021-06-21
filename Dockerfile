FROM adoptopenjdk/openjdk11

WORKDIR /app

EXPOSE 8080

COPY build/libs/order-service-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "order-service-1.0-SNAPSHOT.jar"]