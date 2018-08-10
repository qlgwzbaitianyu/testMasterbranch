package com.shopping.prac.service;

import com.shopping.prac.repository.ProductRepo;
import com.shopping.prac.shoppingbeans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepo productrepo;

    private final RestTemplate restTemplate;

    public ProductServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Product findProductByid(int id) {
        return productrepo.findById(id).get();
    }

    @Override
    public List<Product> findProductByname(String name) {
        return productrepo.findProductsByProductName(name);
    }

    @Override
    public List<Product> findAllProducts() {
        return productrepo.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return productrepo.save(product);
    }

    @Override
    public void deleteProductById(int id) {
        productrepo.deleteById(id);
    }

    /**
     * to get product from UserMicroService
     * @param name
     * @return product Object from UserMicroservice
     */
    public Product getProductFromUserService(String name){
        return restTemplate.getForObject("/userService/{name}", Product.class, name);
    }

    /**
     * to do unit test on void return value
     * @param a
     * @param b
     */
    @Override
    public void aPlusB(int a, int b) {
        int c = a + b;
    }
}
