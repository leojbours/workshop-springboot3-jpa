package com.learningspring.course.controllers;

import com.learningspring.course.entities.Category;
import com.learningspring.course.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {
  CategoryService categoryService;

  @Autowired
  public void setCategoryService(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    return ResponseEntity.ok().body(categoryService.findAll());
  }

  @GetMapping(value = ("/{id}"))
  public ResponseEntity<Category> findById(@PathVariable Long id) {
    return ResponseEntity.ok().body(categoryService.findById(id));
  }
}
