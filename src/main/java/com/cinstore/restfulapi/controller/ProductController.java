package com.cinstore.restfulapi.controller;

import com.cinstore.restfulapi.entity.Product;
import com.cinstore.restfulapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    //add product
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    //add more products (List)
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    //get all product
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    //find by id product
    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable String id) {
        return service.getProductsById(id);
    }

    //find by name product
    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductsByName(name);
    }

    //update
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        return service.deleteProduct(id);
    }

    //getImage
}
