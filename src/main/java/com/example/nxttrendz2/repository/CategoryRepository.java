package com.example.nxttrendz2.repository;

import com.example.nxttrendz2.model.Category;
import java.util.ArrayList;

public interface CategoryRepository {
    ArrayList<Category> getAllCategories();
    Category createCategory(Category category);
    Category getCategoryById(int categoryId);
    Category updateCategory(int categoryId, Category category);
    void deleteCategory(int categoryId);
}
