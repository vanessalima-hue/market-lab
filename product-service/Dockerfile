# Estágio 1: Build da aplicação
# Usa uma imagem base oficial do Maven com o Java 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o projeto inteiro para o ambiente de build
# Isso garante que o Maven consiga encontrar o POM pai
COPY . .

# Compila apenas o módulo `product-service` e suas dependências.
# Os flags `-pl` e `-am` são essenciais para projetos multi-módulos.
RUN mvn -pl product-service -am clean package -DskipTests

# Estágio 2: Execução da aplicação
# Usa uma imagem base mais leve do Java 17 para o ambiente de execução
FROM eclipse-temurin:17-jre-focal

# Define o diretório de trabalho da aplicação
WORKDIR /app

# Copia o JAR do estágio de build
COPY --from=build /app/product-service/target/product-service-*.jar ./app.jar

# Expõe a porta que a aplicação vai usar
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java","-jar","/app/app.jar"]
