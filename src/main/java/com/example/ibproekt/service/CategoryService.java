package com.example.ibproekt.service;

import com.example.ibproekt.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();

    void save(Category category);

    void deleteCategoryById(long id);
    Optional<Category> findById(long id);
}
