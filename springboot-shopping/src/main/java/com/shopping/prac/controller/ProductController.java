package com.shopping.prac.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.prac.service.ProductService;
import com.shopping.prac.shoppingbeans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> testMerge(){
        Product p = new Product(3, "superBug");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonProduct = "";
        try {
            jsonProduct = objectMapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(p);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProductById(@PathVariable int id){
        service.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
