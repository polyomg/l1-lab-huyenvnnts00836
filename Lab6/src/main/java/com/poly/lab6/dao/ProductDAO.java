package com.poly.lab6_1.dao;

import com.poly.lab6_1.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Integer> {
}
