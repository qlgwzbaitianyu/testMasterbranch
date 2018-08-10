package com.shopping.prac.service;

import com.shopping.prac.repository.ProductRepo;
import com.shopping.prac.shoppingbeans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {


    Product findProductByid(int id);


    List<Product>  findProductByname(String name);


    List<Product> findAllProducts();


    Product addProduct(Product product);


    /**
     * to get product from UserMicroService
     * @param name
     * @return product Object from UserMicroservice
     */
    Product getProductFromUserService(String name);

    /**
     * to do unit test on void return value
      * @param a
     * @param b
     */
    void aPlusB(int a, int b);



    void deleteProductById(int id);
}
