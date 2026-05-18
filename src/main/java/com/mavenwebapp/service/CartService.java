package com.mavenwebapp.service;

import com.mavenwebapp.model.CartItem;
import com.mavenwebapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private final List<CartItem> cartItems = new ArrayList<>();

    public void addToCart(Product product) {

        cartItems.add(new CartItem(product, 1));
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}