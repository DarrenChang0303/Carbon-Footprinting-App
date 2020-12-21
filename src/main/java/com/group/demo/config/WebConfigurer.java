package com.group.demo.config;

import com.group.demo.config.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Tonghui Li
 * @createdTime 2019/11/30
 * @description
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/user/login").excludePathPatterns("/plugins/**").excludePathPatterns("/dist/**");
    }
}
