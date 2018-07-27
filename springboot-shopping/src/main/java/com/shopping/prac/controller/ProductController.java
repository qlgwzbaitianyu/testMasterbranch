package com.shopping.prac.controller;

import com.shopping.prac.service.ProductService;
import com.shopping.prac.shoppingbeans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/products")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping(path = "/add")
    public Product addProduct(@RequestBody Product product){
        return service.addProduct(product);
    }

    @GetMapping(value = "/all")
    public List<Product> getAllProduct(){
        return service.findAllProducts();
    }

    @GetMapping(path = "/{id}")
    public Product getProductById(@PathVariable int id){
        return service.findProductByid(id);
    }

    @GetMapping
    public List<Product> getProductByName(@RequestParam(value = "productName") String name){
        return service.findProductByname(name);
    }

    @GetMapping(path = "/testmerge")
    public void testMerge(){
        System.out.println("yyyyyyyyyy");
    }

}
