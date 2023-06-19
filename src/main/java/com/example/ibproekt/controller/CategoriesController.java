package com.example.ibproekt.controller;

import com.example.ibproekt.entity.Category;
import com.example.ibproekt.service.ProductService;
import com.example.ibproekt.service.impl.CategoryServiceImpl;
import com.example.ibproekt.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
//@RequestMapping("categories")
public class CategoriesController {

    private final CategoryServiceImpl categoryService;
    private final ProductServiceImpl productService;


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

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(
            Model model,
            @PathVariable("id") long id
    ){

        //ne mi se veruva deka vaka mora da go napravam
        //mozebi ima podobar nachin, ama ispagja bojle e samo voopsto da ne se koristi jpa
        //i direktno da se koristi baza

        productService.getAllProducts().stream()
                .filter(product -> product.getCategory().equals(categoryService.findById(id)))
                .forEach(product -> {
                    productService.deleteProductById(product.getId());
                });

        categoryService.deleteCategoryById(id);

        return "redirect:/categories";
    }

    @PostMapping(value = "/categories")
    public String saveCategory(@ModelAttribute("category")Category category){
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
}
