package com.shopping.prac.repository;

import com.shopping.prac.shoppingbeans.Product;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.util.*;

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

    @Test
    public void coreJavaTest() {
        Integer a = 123;
        String str = a.toString();
        str.length();
        List<Product> mylist = new LinkedList();

        mylist.stream().filter(x -> {
            if(x.getProductId() > 0){
                return true;
            }
            else{
                return false;
            }
        }).forEach(x -> x.getProductName());

        Assert.assertTrue(1 == 1);


        Stack s = new Stack();
        String myStr = "aa";
        myStr.toCharArray();

        char x = (char)(-1 + 90);

        

        /*List list2 = new ArrayList();
        list.stream().forEach(
                c -> list2.add(c)
        );
*/
        Set<String> myset = new HashSet<>();




    }


}