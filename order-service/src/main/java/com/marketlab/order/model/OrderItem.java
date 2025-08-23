package com.marketlab.order.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderItem(
  @NotNull Long productId,
  @Min(1) int quantity
) {}
