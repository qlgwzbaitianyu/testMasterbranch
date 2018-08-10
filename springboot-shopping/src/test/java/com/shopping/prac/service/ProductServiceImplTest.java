package com.shopping.prac.service;

import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopping.prac.repository.ProductRepo;
import com.shopping.prac.shoppingbeans.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(ProductServiceImpl.class)
//@SpringBootTest
public class ProductServiceImplTest {
   /* @TestConfiguration
    static class TestConfig{
        @Bean
        public ProductService getProductService() {
            return new ProductServiceImpl();
        }
    }*/


    @MockBean
    private ProductRepo productrepo;

    @Autowired
    public ProductService productService;


    @Autowired
    private MockRestServiceServer server;

    @Autowired
    private ObjectMapper objectMapper;


    @Before
    public void setUp() throws Exception {
        Product p = new Product(999, "testProduct123");
        String jsonProduct = objectMapper.writeValueAsString(p);

        System.out.println("this is in test setup  " + jsonProduct);

        this.server.expect(requestTo("/userService/testProduct"))
                .andRespond(withSuccess(jsonProduct, MediaType.APPLICATION_JSON));
    }

    @Test
    public void testFindProductById() {
        Product product = new Product(1,"aa");
        when(productrepo.findById(1)).thenReturn(Optional.ofNullable(product));
        assertEquals(product, productService.findProductByid(1));
    }

    @Test
    public void testGetProductFromUserService() {
        Product p = this.productService.getProductFromUserService("testProduct");

        System.out.println("in test method: " + p);
        //Assert.assertEquals(99, p.getProductId());
        Assert.assertEquals("testProduct123", p.getProductName());
    }

    @Test
    public void testAPlusB() {
        ProductServiceImpl productService = mock(ProductServiceImpl.class);
        doNothing().when(productService).aPlusB(isA(Integer.class), isA(Integer.class));
        productService.aPlusB(1,1);
        verify(productService, times(1)).aPlusB(1, 1);
    }


}