# Estágio de build
# Usa uma versão mais recente e segura do Maven e OpenJDK
FROM maven:3.9-eclipse-temurin-17 AS build

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o pom.xml pai e o pom.xml do módulo
COPY ../pom.xml .
COPY pom.xml ./product-service/pom.xml

# Copia todo o código-fonte do módulo
COPY ./src ./src

# Compila e empacota apenas este módulo
RUN mvn clean package -DskipTests

# Estágio de execução
# Usa uma imagem base mais leve para a execução
FROM eclipse-temurin:17-jre

# Define o diretório de trabalho da aplicação
WORKDIR /app

# Copia o JAR do estágio de build para o estágio de execução
COPY --from=build /app/target/product-service-*.jar ./app.jar

# Expõe a porta que a aplicação vai usar
# O Spring Boot vai escolher uma porta aleatória, mas é uma boa prática expor uma porta para testes
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java","-jar","/app/app.jar"]
