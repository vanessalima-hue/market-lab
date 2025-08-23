package com.marketlab.order.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record Order(
  String id,
  @NotEmpty List<OrderItem> items,
  double total
) {}
