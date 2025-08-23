CREATE TABLE products (
  id BIGINT PRIMARY KEY,
  name VARCHAR(255),
  sku  VARCHAR(64),
  price DOUBLE
);

INSERT INTO products (id, name, sku, price) VALUES
(1,'Camiseta Basic','TSHIRT-001',49.90),
(2,'Calça Jeans','JEANS-101',149.90),
(3,'Tênis Runner','SHOE-501',299.00);
