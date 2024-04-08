package demo.config;

import org.springframework.http.HttpMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * @author xiao
 * @data 2024/4/8 8:27
 */
public class SwaggerConfiguration {
    public Docket webApiDoc(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("用户端接口文档")
                .pathMapping("/")
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("demo"))
                .paths(PathSelectors.ant("/api/**"))
                .build()
                .globalRequestParameters(globalRequestParameters())
                .globalResponses(HttpMethod.GET,getGlobalResponseMessage())
                .globalResponses(HttpMethod.POST,getGlobalResponseMessage());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("springdloud-demo")
                .description("微服务接口文档")
                .version("v1.0")
                .build();
    }

    private List<RequestParameter> globalRequestParameters() {
        return Collections.singletonList(new RequestParameterBuilder()
                .name("token")
                .description("登录命令")
                .in(ParameterType.HEADER)
                .query(o->o.model(m->m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build()
        );
    }

    private List<Response> getGlobalResponseMessage() {
        return Collections.singletonList(new ResponseBuilder()
                .code("4xx")
                .description("请求错误，根据code和msg检查")
                .build());
    }
}
