package com.learningspring.course.service;

import com.learningspring.course.entities.Category;
import com.learningspring.course.repositories.CategoryRepositories;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
  private CategoryRepositories categoryRepositories;

  public CategoryService(CategoryRepositories categoryRepositories) {
    this.categoryRepositories = categoryRepositories;
  }

  public List<Category> findAll() {
    return categoryRepositories.findAll();
  }

  public Category findById(Long id) {
    return categoryRepositories.findById(id).get();
  }
}
