package com.shopping.prac.testController;

import com.shopping.prac.controller.ProductController;
import com.shopping.prac.service.ProductService;
import com.shopping.prac.shoppingbeans.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProductController.class)
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProductByIdTest(){
        Product product = new Product(1,"aa");
        when(productService.findProductByid(1)).thenReturn(product);
        try {
            mockMvc.perform(MockMvcRequestBuilders
            .get("/v1/products/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .equals(product);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
