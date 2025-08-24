# api-gateway/Dockerfile
# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# O Render já copia o conteúdo do rootDir para /app
# Não precisamos copiar novamente

# O comando de build deve ser executado a partir do diretório raiz do módulo
# sem a flag -pl
RUN mvn clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/target/api-gateway-*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
