package com.micro.hospital.config.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
/**
 * spring-web.xml
 * 扫描路径因为springboot是全面搜索，不需要配置扫描包的路径
 */
@Deprecated
public class MvcConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * <mvc:resources mapping="/resources/**" location="/resources/" />
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
    }

    /**
     * <mvc:default-servlet-handler />
     *
     * @param configurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * <bean id="viewResolver"
     * class="org.springframework.web.servlet.view.InternalResourceViewResolver">
     * <property name="prefix" value="/WEB-INF/html/"></property>
     * <property name="suffix" value=".html"></property>
     * </bean>
     *
     * @return
     */
    public ViewResolver createViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setApplicationContext(this.applicationContext);
        viewResolver.setCache(false);
        viewResolver.setPrefix("/WEB-INF/html");
        viewResolver.setSuffix(".html");
        return viewResolver;
    }
}
