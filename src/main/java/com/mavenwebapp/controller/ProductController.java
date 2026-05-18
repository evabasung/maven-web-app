package com.mavenwebapp.controller;

import com.mavenwebapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String products(Model model) {

        model.addAttribute("products",
                productService.getAllProducts());

        return "products";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable int id,
                                 Model model) {

        model.addAttribute("product",
                productService.getProductById(id));

        return "product-details";
    }
}