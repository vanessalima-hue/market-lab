# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY api-gateway/pom.xml .
COPY api-gateway/src ./src
RUN mvn clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/target/api-gateway-*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
