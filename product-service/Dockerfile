# product-service/Dockerfile
# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -pl product-service -am clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/product-service/target/product-service-*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
