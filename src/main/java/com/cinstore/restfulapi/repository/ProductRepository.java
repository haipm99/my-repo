package com.cinstore.restfulapi.repository;

import com.cinstore.restfulapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, String> {

    Product findByName(String name);

//    @Query()
}
