package com.rga.springwebapp.dao;

import com.rga.springwebapp.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
}
