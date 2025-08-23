package com.marketlab.order.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ProductClient {
  private final WebClient webClient;

  public ProductClient(WebClient.Builder builder,
                       @Value("${PRODUCT_SERVICE_URI:lb://product-service}") String baseUri) {
    this.webClient = builder.baseUrl(baseUri).build();
  }

  public record ProductDTO(Long id, String name, String sku, double price) {}

  public ProductDTO getProduct(Long id) {
    return webClient.get().uri("/products/{id}", id)
      .retrieve().bodyToMono(ProductDTO.class).block();
  }
}
