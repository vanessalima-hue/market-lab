package com.marketlab.order.web;

import com.marketlab.order.client.ProductClient;
import com.marketlab.order.model.Order;
import com.marketlab.order.model.OrderItem;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {
  private final ProductClient productClient;

  public OrderController(ProductClient productClient) { this.productClient = productClient; }

  @PostMapping
  public Order create(@Valid @RequestBody List<OrderItem> items) {
    double total = items.stream()
      .mapToDouble(i -> productClient.getProduct(i.productId()).price() * i.quantity())
      .sum();
    return new Order(UUID.randomUUID().toString(), items, total);
  }
}
