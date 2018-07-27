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

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepoTest {

    @Autowired
    ProductRepo productRepo;
    @Autowired
    /*DataSource dataSource;*/

    @Test
    public void testFindProductsByProductName() {
//        Product product1 = new Product(1, "aa");
//        String productName = "aa";
//        List<Product> productList = productRepo.findProductsByProductName(productName);
//        Assert.assertEquals(product1.getProductName(), productList.get(0).getProductName());
    }
}