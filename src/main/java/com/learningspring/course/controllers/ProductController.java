package com.learningspring.course.controllers;

import com.learningspring.course.entities.Product;
import com.learningspring.course.service.ProductService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
  private ProductService productService;

  public ProductController(ProductService productService) {
      this.productService = productService;
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAllProducts() {
    return ResponseEntity.ok().body(productService.findAll());
  }

  @GetMapping(value = ("/{id}"))
  public ResponseEntity<Product> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(productService.findById(id));
  }
}
