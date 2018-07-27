package com.shopping.prac.service;

import com.shopping.prac.repository.ProductRepo;
import com.shopping.prac.shoppingbeans.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productrepo;

    @Override
    public Product findProductByid(int id) {
        return productrepo.findById(id).get();
    }

    @Override
    public List<Product> findProductByname(String name) {
        return productrepo.findProductsByProduct_name(name);
    }

    @Override
    public List<Product> findAllProducts() {
        return productrepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productrepo.save(product);
    }
}
