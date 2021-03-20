package com.cinstore.restfulapi.service;

import com.cinstore.restfulapi.entity.Product;
import com.cinstore.restfulapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductsById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductsByName(String name) {
        return repository.findByName(name);
    }

    public String deleteProduct(String id) {
        repository.deleteById(id);
        return "Product removed !!" + id;
    }

    public Product updateProduct(Product product) {
        Product existProduct = repository.findById(product.getId()).orElse(null);

        existProduct.setName(product.getName());
        existProduct.setImage(product.getImage());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());
        existProduct.setStat(product.getStat());

        return repository.save(existProduct);
    }

}
