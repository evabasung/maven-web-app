package com.mavenwebapp.service;

import com.mavenwebapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {

        products.add(
                new Product(
                        1,
                        "Laptop",
                        "Gaming Laptop",
                        1200.00,
                        "https://via.placeholder.com/250"
                )
        );

        products.add(
                new Product(
                        2,
                        "Phone",
                        "Smart Phone",
                        700.00,
                        "https://via.placeholder.com/250"
                )
        );
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {

        for (Product product : products) {

            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }
}