package com.cd.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class MyWebAppConfiger extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {

//        registry.addResourceHandler("/myresources/**").addResourceLocations("classpath:/myresources/");
        super.addResourceHandlers(registry);
    }

    @Override
    public ViewResolver mvcViewResolver() {

        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/classes/templates/");
        viewResolver.setSuffix(".htmm");
        return  viewResolver;
//        return super.mvcViewResolver();
    }
}
