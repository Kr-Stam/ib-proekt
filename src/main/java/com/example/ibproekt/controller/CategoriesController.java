package com.example.ibproekt.controller;

import com.example.ibproekt.entity.Category;
import com.example.ibproekt.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("categories")
public class CategoriesController {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoriesController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String getAllCategories(Model model){
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/categories/")
    public String createCategory(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "categories";
    }

    @PostMapping("/categories/")
    public String saveCategory(@ModelAttribute("category")Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
}
