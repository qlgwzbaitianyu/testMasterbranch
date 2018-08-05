package com.shopping.prac.service;

import java.util.Optional;
import com.shopping.prac.repository.ProductRepo;
import com.shopping.prac.shoppingbeans.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
public class ProductServiceImplTest {
    @TestConfiguration
    static class TestConfig{
        @Bean
        public ProductService getProductService() {
            return new ProductServiceImpl();
        }
    }


    @MockBean
    private ProductRepo productrepo;

    @Autowired
    public ProductService productService;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findProductByid() {
        Product product = new Product(1,"aa");
        when(productrepo.findById(1)).thenReturn(Optional.ofNullable(product));
        assertEquals(product, productService.findProductByid(1));
    }

   /* @Test
    public void findProductByname() {
    }

    @Test
    public void findAllProducts() {
    }*/
}