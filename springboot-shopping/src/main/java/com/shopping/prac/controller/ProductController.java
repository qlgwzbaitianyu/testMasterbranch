package com.shopping.prac.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.prac.pagination.PageResource;
import com.shopping.prac.service.ProductService;
import com.shopping.prac.shoppingbeans.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

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

    /**
     * Spring hateos on get by ID
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Resource<Product>> getProductById(@PathVariable int id){

        Product p = service.findProductByid(id);
        Link selfLink = linkTo(methodOn(ProductController.class).getProductById(id)).withSelfRel();
        Link allLink = linkTo(methodOn(ProductController.class).getAllProduct()).withRel("allProducts");
        Resource<Product> resources = new Resource<>(p, selfLink);
        resources.add(allLink);

        //p.add(linkTo(methodOn(ProductController.class).getProductById(id)).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(resources);
    }

    @GetMapping
    public List<Product> getProductByName(@RequestParam(value = "productName") String name){
        return service.findProductByname(name);
    }

    @GetMapping(path = "/testmerge")
    public ResponseEntity<String> testMerge(){
        Product p = new Product(3, "superBug");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonProduct = "";
        try {
            jsonProduct = objectMapper.writeValueAsString(p);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(jsonProduct);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteProductById(@PathVariable int id){
        service.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    /**
     * pagination
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value="/testPage",method=RequestMethod.GET)
    public PageResource<Product> allProductsWithPagination(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam
            (value = "limit", defaultValue = "2") int limit) throws JsonProcessingException {
        Pageable pageableRequest = PageRequest.of(page, limit);

        Page<Product> products = service.findProductByNameWithPagination(pageableRequest);
        PageResource pageResource = new PageResource<>(products,"page","limit");

        return pageResource;
    }

}
