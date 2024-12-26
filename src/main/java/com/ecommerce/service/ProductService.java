package com.ecommerce.service;

import com.ecommerce.model.Product;

import java.util.Optional;

public interface ProductService {
    public Product save(Product product);
    public Optional<Product> get(Integer id);
    public void update(Product product);
    public void delete(Integer id);
}
