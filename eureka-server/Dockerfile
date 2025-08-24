# Usa uma imagem base para a compilação (JDK)
FROM maven:3.8.6-openjdk-17 AS build

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o pom.xml pai para a raiz
COPY pom.xml .

# Copia os pom.xml dos módulos para seus respectivos diretórios
COPY eureka-server/pom.xml eureka-server/pom.xml
COPY api-gateway/pom.xml api-gateway/pom.xml
COPY product-service/pom.xml product-service/pom.xml
COPY order-service/pom.xml order-service/pom.xml

# Executa o download de dependências
# Isso é um truque para otimizar o cache do Docker, já que as dependências
# raramente mudam. Ele evita que o Maven precise baixar tudo novamente
# a cada pequena mudança de código.
RUN mvn dependency:go-offline -B

# Copia o código-fonte de todos os módulos
COPY . .

# Compila apenas o módulo necessário e suas dependências
# (Substitua "eureka-server" pelo nome do seu módulo)
RUN mvn clean package -DskipTests -pl eureka-server -am

# Usa uma imagem base mais leve para a execução
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho da aplicação
WORKDIR /app

# Copia o JAR do módulo compilado da etapa de "build"
# (Substitua "eureka-server" pelo nome do seu módulo)
COPY --from=build /app/eureka-server/target/*.jar ./app.jar

# Define o comando para iniciar a aplicação
# EXPOSE [PORTA]
# (Ajuste a porta de acordo com o serviço, por exemplo, 8761 para o Eureka)
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "app.jar"]
