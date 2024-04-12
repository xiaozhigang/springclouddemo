package demo.interceptor;

import demo.enums.BizCodeEnum;
import demo.model.LoginUser;
import demo.util.CommonUtil;
import demo.util.JWTUtil;
import demo.util.JsonData;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiao
 * @data 2024/4/8 8:24
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    public static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        if (token == null) {
            token = request.getParameter("token");
        }

        if (StringUtils.isNotBlank(token)) {
            Claims claims = JWTUtil.checkJWT(token);
            if (claims == null) {
                CommonUtil.sendJsonMessage(response, JsonData.buildResult(BizCodeEnum.ACCOUNT_UNLOGIN));
                return false;
            }
            Long id = Long.valueOf(claims.get("id").toString());
            String name = claims.get("name").toString();
            int role = Integer.parseInt(claims.get("role").toString());

            LoginUser loginUser = new LoginUser(id, name, role);
            threadLocal.set(loginUser);
            return true;
        }
        CommonUtil.sendJsonMessage(response, JsonData.buildResult(BizCodeEnum.ACCOUNT_UNLOGIN));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

}