package com.example.ibproekt.controller;

import com.example.ibproekt.entity.Product;
import com.example.ibproekt.service.impl.CategoryServiceImpl;
import com.example.ibproekt.service.impl.ManufacturerServiceImpl;
import com.example.ibproekt.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;
    private final CategoryServiceImpl categoryService;
    private final ManufacturerServiceImpl manufacturerService;

    @GetMapping(path = "/products")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @GetMapping(path = "/products/add")
    public String createProduct(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("manufacturers", manufacturerService.getALlManufacturers());
        return "add-new-product";
    }

    @GetMapping(path = "/products/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") long id){
        productService.deleteById(id);
        return "redirect:/products";
    }

    @PostMapping(path = "/products")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);
        return "redirect:/products";
    }
}
