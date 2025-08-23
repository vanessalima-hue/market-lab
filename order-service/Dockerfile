# order-service/Dockerfile
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY ../pom.xml ./../pom.xml
COPY pom.xml ./pom.xml
RUN mvn -q -f ../pom.xml -DskipTests clean package -pl order-service -am

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/order-service-*.jar app.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/app/app.jar"]
