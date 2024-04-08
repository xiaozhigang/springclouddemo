package demo.service;

import demo.request.UserLoginRequest;
import demo.util.JsonData;

/**
 * @author xiao
 * @data 2024/4/7 23:12
 */
public interface UserLoginService {
    /**
     * 用户登录
     * @param userLoginRequest userLoginRequest
     * @return JsonData
     */
    JsonData loginByAccount(UserLoginRequest userLoginRequest);

    /**
     * 用户登录
     * @param userLoginRequest userLoginRequest
     * @return JsonData
     */
    JsonData loginByGitHub(UserLoginRequest userLoginRequest);

    /**
     * 用户登录
     * @param userLoginRequest userLoginRequest
     * @return JsonData
     */
    JsonData loginByLdap(UserLoginRequest userLoginRequest);
}
