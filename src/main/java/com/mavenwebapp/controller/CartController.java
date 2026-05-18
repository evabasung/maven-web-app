package com.mavenwebapp.controller;

import com.mavenwebapp.model.Product;
import com.mavenwebapp.service.CartService;
import com.mavenwebapp.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService,
                          ProductService productService) {

        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/cart")
    public String cart(Model model) {

        model.addAttribute("cartItems",
                cartService.getCartItems());

        return "cart";
    }

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable int id) {

        Product product =
                productService.getProductById(id);

        cartService.addToCart(product);

        return "redirect:/cart";
    }
}