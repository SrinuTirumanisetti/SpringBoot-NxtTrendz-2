package com.example.nxttrendz2.service;

import com.example.nxttrendz2.model.Category;
import com.example.nxttrendz2.repository.CategoryJpaRepository;
import com.example.nxttrendz2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CategoryJpaService implements CategoryRepository {

    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public List<Category> getCategories() {
        return categoryJpaRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        return categoryJpaRepository.save(category);
    }

    @Override
    public Category getCategoryById(int categoryId) {
        return categoryJpaRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Category updateCategory(int categoryId, Category category) {
        Category existing = getCategoryById(categoryId);
        existing.setName(category.getName());
        existing.setDescription(category.getDescription());
        return categoryJpaRepository.save(existing);
    }

    @Override
    public void deleteCategory(int categoryId) {
        Category existing = getCategoryById(categoryId);
        categoryJpaRepository.delete(existing);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}
