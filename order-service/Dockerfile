# order-service/Dockerfile

# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos necessários
COPY pom.xml .
COPY src ./src

# Compila o projeto
RUN mvn clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app

# Copia o jar gerado no build
COPY --from=build /app/target/*.jar app.jar

# Order Service expõe a porta 8082 (diferente do Gateway)
EXPOSE 8082
ENTRYPOINT ["java","-jar","app.jar"]
