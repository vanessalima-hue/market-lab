# Etapa 1: Build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia POM pai e módulos (preserva hierarquia)
COPY pom.xml .
COPY eureka-server ./eureka-server
COPY api-gateway ./api-gateway
COPY product-service ./product-service
COPY order-service ./order-service

# Executa build só do eureka, mas enxergando o POM pai
RUN mvn -pl eureka-server -am clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/eureka-server/target/*.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","app.jar"]
