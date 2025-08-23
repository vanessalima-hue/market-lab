# market-lab

Sistema simples com **catálogo de produtos** e **simulação de pedidos**, composto por **dois microsserviços**:

- `product-service` – catálogo (H2 )
- `order-service` – cria pedidos somando os preços consultados no catálogo

Infra de apoio:
- **API Gateway** (`api-gateway`) com Spring Cloud Gateway
- **Service Discovery** (`eureka-server`) com Netflix Eureka

## Arquitetura


