package demo.config;

import demo.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiao
 * @data 2024/4/8 8:31
 */
@Configuration
@Slf4j
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/user/*/**", "/api/product/*/**")
                .excludePathPatterns("/api/product/*/page", "/api/product/*/insert", "/api/product/*/delete", "/api/product/*/update", "/api/product/*/health");
    }
}
