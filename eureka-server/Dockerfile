# Etapa 1: Build da aplicação
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .   # Copia TODO o projeto, incluindo o pom.xml pai
RUN mvn -pl eureka-server -am clean package -DskipTests
# -pl eureka-server => builda só esse módulo
# -am => também builda os módulos que ele depende

# Etapa 2: Imagem final
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/eureka-server/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
