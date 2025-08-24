# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY product-service/pom.xml .
COPY product-service/src ./src
RUN mvn clean package -DskipTests -f pom.xml

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/target/product-service-*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
