# eureka-server/Dockerfile
# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn -pl eureka-server -am clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/eureka-server/target/eureka-server-*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/app/app.jar"]
