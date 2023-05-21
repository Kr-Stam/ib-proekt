package com.example.ibproekt.service;

import com.example.ibproekt.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void saveCategory(Category category);
}
