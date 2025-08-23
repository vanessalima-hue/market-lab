package com.marketlab.product.repo;

import com.marketlab.product.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ProductRepository {
  private final JdbcTemplate jdbc;

  public ProductRepository(JdbcTemplate jdbc) { this.jdbc = jdbc; }

  public List<Product> findAll() {
    return jdbc.query("SELECT id, name, sku, price FROM products",
      (rs, i) -> new Product(rs.getLong("id"), rs.getString("name"),
                             rs.getString("sku"), rs.getDouble("price")));
  }

  public Product findById(Long id) {
    return jdbc.queryForObject(
      "SELECT id, name, sku, price FROM products WHERE id = ?",
      (rs, i) -> new Product(rs.getLong("id"), rs.getString("name"),
                             rs.getString("sku"), rs.getDouble("price")),
      id
    );
  }
}
