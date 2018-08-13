package com.atguigu.springboot.spring04webrestfulcrud.config;

import com.atguigu.springboot.spring04webrestfulcrud.component.LoginHandlerInterceptor;
import com.atguigu.springboot.spring04webrestfulcrud.component.MyLocalResolver;
import org.hibernate.validator.constraints.EAN;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfiger extends WebMvcConfigurerAdapter{

  /*  public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        return new EmbeddedServletContainerCustomizer(){
            //定制嵌入式的Servlet容器的相关规则
            public void customize(ConfigurableEmbeddedServletContainer container){
                container.setPort(8083);
            }
        };
    }*/

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                    .excludePathPatterns("/","/user/login","/webjars/**","/asserts/**");
            }

        };

        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new  MyLocalResolver();
    }
}
