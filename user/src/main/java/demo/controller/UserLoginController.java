package demo.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiao
 * @data 2024/4/7 23:11
 */
@Api(tags = "用户登录模块")
@RestController
@RequestMapping("/api/user/v1")
public class UserLoginController {
}
