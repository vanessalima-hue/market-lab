# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY order-service/pom.xml .
COPY order-service/src ./src
RUN mvn clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/target/order-service-*.jar ./app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app/app.jar"]
