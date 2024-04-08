package demo.config;

import demo.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xiao
 * @data 2024/4/8 8:31
 */
public class InterceptorConfig implements WebMvcConfigurer {
    public void addInterceptor(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/api/user/*/**","/api/product/*/**")
                .excludePathPatterns("/api/user/*/loginByAccount", "/api/user/*/loginByGitHub", "/api/user/*/loginByLdap");
    }
}
