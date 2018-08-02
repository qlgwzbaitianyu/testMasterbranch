package com.shopping.prac.repository;

import com.shopping.prac.shoppingbeans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "product", path = "product")
public interface ProductRepo extends JpaRepository<Product, Integer> {


    List<Product> findProductsByProductName(String name);

}
