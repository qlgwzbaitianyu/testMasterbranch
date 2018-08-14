package com.shopping.prac.configuration;

import com.shopping.prac.filter.FirstFilter;
import com.shopping.prac.filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebFilterConfig {

    @Bean
    public FilterRegistrationBean firstFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("firstFilter");
        FirstFilter firstFilter = new FirstFilter();
        filterRegistrationBean.setFilter(firstFilter);
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean secondFilterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setName("secondFilter");
        SecondFilter secondFilter = new SecondFilter();
        filterRegistrationBean.setFilter(secondFilter);
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

}
