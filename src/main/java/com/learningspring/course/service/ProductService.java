package com.learningspring.course.service;

import com.learningspring.course.entities.Product;
import com.learningspring.course.repositories.ProductRepositories;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private ProductRepositories productRepositories;

  public ProductService(ProductRepositories productRepositories) {
    this.productRepositories = productRepositories;
  }

  public List<Product> findAll() {
    return productRepositories.findAll();
  }

  public Product findById(Long id) {
    return productRepositories.findById(id).get();
  }
}
