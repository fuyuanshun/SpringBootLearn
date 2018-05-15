package com.fys.util;

import com.fys.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfAdapter implements WebMvcConfigurer {

    /**
     *  拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/addMusic", "/selectMusic", "/musicList.jsp");
    }

    /**
     **  配置访问静态资源
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/my/**").addResourceLocations("classpath:/my/");
    }

    /**
     * 直接访问http://localhost:8080/heihei可以直接跳转到musicList.jsp页面了
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/heihei").setViewName("musicList");
    }
}
