package com.shopping.prac.repository;

import com.shopping.prac.shoppingbeans.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;
import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataJpaTest // will roll back the data
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepoTest {

    @Autowired
    ProductRepo productRepo;
   /* @Autowired
    DataSource dataSource;*/

    @Test
    public void testFindProductsByProductName() {

    }

    @Test
    public void testProductsSave() {
        Product product1 = new Product(4, "xx");
        Product product2 = productRepo.save(product1);

        Assert.assertEquals(product1.getProductName(), product2.getProductName());
        Assert.assertTrue(product2.getProductId() > 0);
    }

    @Test
    public void testProductSearch() {
        Product productDefault = new Product(1, "aa");
        Product product = productRepo.findById(1).orElse(productDefault);

        System.out.println(product);

        Assert.assertEquals(productDefault.getProductName(), product.getProductName());
    }

    @Test(expected = NoSuchElementException.class)
    public void testProductDelete() {
        productRepo.deleteById(1);
        productRepo.findById(1).get();
    }

}