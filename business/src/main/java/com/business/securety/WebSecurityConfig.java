package com.business.securety;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN");

        auth
                .inMemoryAuthentication()
                .withUser("guest").password("").roles("GUEST");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/", "/index/**","/css/**","/showAll", "/searc","/lang/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/index/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }



}
