package com.poly.lab6_1.controller;

import com.poly.lab6_1.dao.ProductDAO;
import com.poly.lab6_1.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    ProductDAO productDAO;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }
}
