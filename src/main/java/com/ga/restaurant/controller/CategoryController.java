package com.ga.restaurant.controller;


import com.ga.restaurant.model.Category;
import com.ga.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // get the menu
    @GetMapping("/categories")
    public List<Category> getCategories() {
        System.out.println("calling getCategories ==>");
        return categoryService.getCategories();
    }

}
