package com.ga.restaurant.service;


import com.ga.restaurant.model.Category;
import com.ga.restaurant.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        System.out.println("service calling getCategories ==>");
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
