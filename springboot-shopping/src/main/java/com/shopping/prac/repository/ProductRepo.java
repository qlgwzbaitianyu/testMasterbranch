package com.shopping.prac.repository;

import com.shopping.prac.shoppingbeans.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {


    public List<Product> findProductsByProductName(String name);

}
