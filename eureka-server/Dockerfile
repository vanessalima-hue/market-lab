# Estágio de build
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY eureka-server/pom.xml .
COPY eureka-server/src ./src
RUN mvn clean package -DskipTests -f pom.xml

# Estágio de execução
FROM eclipse-temurin:17-jre-focal
WORKDIR /app
COPY --from=build /app/target/eureka-server-*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/app/app.jar"]
