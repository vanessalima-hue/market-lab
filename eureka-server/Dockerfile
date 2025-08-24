# eureka-server/Dockerfile
# Usa uma imagem base oficial do Maven com o Java 17 para o build
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o projeto inteiro para o ambiente de build para que o Maven possa encontrar o POM pai
COPY . .

# Compila apenas o módulo `eureka-server` e suas dependências
RUN mvn -pl eureka-server -am clean package -DskipTests

# Usa uma imagem base mais leve do Java 17 para o ambiente de execução
FROM eclipse-temurin:17-jre-focal

# Define o diretório de trabalho da aplicação
WORKDIR /app

# Copia o JAR do estágio de build para o estágio de execução
COPY --from=build /app/eureka-server/target/eureka-server-*.jar ./app.jar

# Expõe a porta que a aplicação vai usar
EXPOSE 8761

# Comando para iniciar a aplicação
ENTRYPOINT ["java","-jar","/app/app.jar"]
