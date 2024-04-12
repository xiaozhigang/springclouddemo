package demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiao
 * @data 2024/4/10 8:09
 */
@SpringBootApplication
@MapperScan("demo.mapper")
public class ProductApplication {
    public static void main(String [] args){
        SpringApplication.run(ProductApplication.class,args);
    }
}
