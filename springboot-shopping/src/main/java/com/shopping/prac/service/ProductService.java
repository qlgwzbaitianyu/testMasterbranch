package com.shopping.prac.service;

import com.shopping.prac.repository.ProductRepo;
import com.shopping.prac.shoppingbeans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public Product findProductByid(int id);


    public List<Product>  findProductByname(String name);


    public List<Product> findAllProducts();


    public Product addProduct(Product product);
}
