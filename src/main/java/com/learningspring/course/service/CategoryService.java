package com.learningspring.course.service;

import com.learningspring.course.entities.Category;
import com.learningspring.course.repositories.CategoryRepositories;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
{
    CategoryRepositories categoryRepositories;
    
    public CategoryService( CategoryRepositories categoryRepositories )
    {
        this.categoryRepositories = categoryRepositories;
    }
    
    public List<Category> findAll()
    {
        return categoryRepositories.findAll();
    }
    
    public Category findById( Long id )
    {
        return categoryRepositories.findById( id ).get();
    }
}
