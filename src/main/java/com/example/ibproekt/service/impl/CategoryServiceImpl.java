package com.example.ibproekt.service.impl;

import com.example.ibproekt.entity.Category;
import com.example.ibproekt.repository.CategoryRepository;
import com.example.ibproekt.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }

    public Category findById(long id) {
        return categoryRepository.findById(id);
    }
}
