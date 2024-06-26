package demo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiao
 * @data 2024/4/7 23:18
 */
@Getter
@Setter
@ApiModel(value = "登录对象",description = "用户登录请求对象")
public class UserLoginRequest {

    @ApiModelProperty(value = "用户名", example = "user_1")
    private String name;

    @ApiModelProperty(value = "密码", example = "123456")
    private String pwd;
}