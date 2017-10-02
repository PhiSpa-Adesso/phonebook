package com.api.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@Profile("login")
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/showAll").setViewName("showAll");
        registry.addViewController("/create").setViewName("create");
        registry.addViewController("/searc").setViewName("searc");
        registry.addViewController("/delete").setViewName("delete");
        registry.addViewController("/edit").setViewName("edit");
        registry.addViewController("/index/login").setViewName("guest_index");
    }

}
