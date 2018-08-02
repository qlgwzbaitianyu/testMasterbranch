package com.shopping.prac.aop;

import com.shopping.prac.shoppingbeans.Product;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Product.class)
public class RepositoryHandler {

    @HandleBeforeCreate(Product.class)
    public void afterGet(Product product){
        System.out.println("!!!! this is from repository event handler " + product.getProductName());
    }

    @HandleBeforeDelete(Product.class)
    public void afterdelete(Product product){
        System.out.println("!!!! this is from repository event handler " + product.getProductName());
    }


}
