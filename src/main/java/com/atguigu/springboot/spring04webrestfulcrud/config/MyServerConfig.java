package com.atguigu.springboot.spring04webrestfulcrud.config;

import com.atguigu.springboot.spring04webrestfulcrud.filter.MyFilter;
import com.atguigu.springboot.spring04webrestfulcrud.listener.MyListener;
import com.atguigu.springboot.spring04webrestfulcrud.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

    //注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new MyServlet(),"/myServlet");
        return  registration;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return  registration;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<MyListener>(new MyListener());


        return registrationBean;
    }
}
