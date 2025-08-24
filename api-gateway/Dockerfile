# api-gateway/Dockerfile
# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia todo o projeto para o contêiner para que o Maven possa encontrar o POM pai
COPY . .

# Compila apenas o módulo `api-gateway` e suas dependências
RUN mvn -pl api-gateway -am clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/api-gateway/target/api-gateway-*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
