package demo.controller;

import demo.request.UserLoginRequest;
import demo.service.UserLoginService;
import demo.util.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    private UserLoginService userLoginService;

    /**
     * 用户登录
     */
    @ApiOperation("用户登录")
    @PostMapping("loginByAccount")
    public JsonData loginByAccount(@ApiParam("用户登录对象") @RequestBody UserLoginRequest userLoginRequest) {
        return userLoginService.loginByAccount(userLoginRequest);
    }

    /**
     * 用户登录
     */
    @ApiOperation("用户登录")
    @PostMapping("loginByGitHub")
    public JsonData loginByGitHub(@ApiParam("用户登录对象") @RequestBody UserLoginRequest userLoginRequest) {
        return userLoginService.loginByGitHub(userLoginRequest);
    }

    /**
     * 用户登录
     */
    @ApiOperation("用户登录")
    @PostMapping("loginByLdap")
    public JsonData loginByLdap(@ApiParam("用户登录对象") @RequestBody UserLoginRequest userLoginRequest) {
        return userLoginService.loginByLdap(userLoginRequest);
    }
}
