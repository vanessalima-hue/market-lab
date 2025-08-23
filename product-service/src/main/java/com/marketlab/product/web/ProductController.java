package com.marketlab.product.web;

import com.marketlab.product.model.Product;
import com.marketlab.product.repo.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductRepository repo;

  public ProductController(ProductRepository repo) { this.repo = repo; }

  @GetMapping
  @Cacheable("products")
  public List<Product> all() { return repo.findAll(); }

  @GetMapping("/{id}")
  @Cacheable(cacheNames = "product", key = "#id")
  public Product byId(@PathVariable Long id) { return repo.findById(id); }
}
