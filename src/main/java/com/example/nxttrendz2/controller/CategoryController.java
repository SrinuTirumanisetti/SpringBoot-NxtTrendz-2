package com.example.nxttrendz2.controller;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.service.CategoryJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class CategoryController {

    @Autowired
    private CategoryJpaService categoryJpaService;

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryJpaService.getCategories();
    }

    @PostMapping("/categories")
    public Category addCategory(@RequestBody Category category) {
        return categoryJpaService.addCategory(category);
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryJpaService.getCategoryById(categoryId);
    }

    @PutMapping("/categories/{categoryId}")
    public Category updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
        return categoryJpaService.updateCategory(categoryId, category);
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable int categoryId) {
        categoryJpaService.deleteCategory(categoryId);
    }
}
