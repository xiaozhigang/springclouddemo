package demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import demo.enums.BizCodeEnum;
import demo.mapper.UserMapper;
import demo.model.LoginUser;
import demo.model.UserDO;
import demo.request.UserLoginRequest;
import demo.service.UserLoginService;
import demo.util.JWTUtil;
import demo.util.JsonData;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author xiao
 * @data 2024/4/7 23:28
 */
public class UserLoginServiceImpl implements UserLoginService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public JsonData loginByAccount(UserLoginRequest request) {
        List<UserDO> userList = userMapper.selectList(new QueryWrapper<UserDO>().eq("name", request.getName()));
        if(userList != null && userList.size() ==1){
            UserDO user = userList.get(0);
            String crypt = Md5Crypt.md5Crypt(request.getPwd().getBytes(), user.getSecret());
            if(crypt.equals(user.getPwd())){
                LoginUser loginUser = LoginUser.builder().build();
                BeanUtils.copyProperties(user,loginUser);
                String token = JWTUtil.geneJsonWebToken(loginUser);
                return JsonData.buildSuccess(token);
            }else {
                return JsonData.buildResult(BizCodeEnum.ACCOUNT_PWD_ERROR);
            }
        }else {
            return JsonData.buildResult(BizCodeEnum.ACCOUNT_UNREGISTER);
        }
    }

    @Override
    public JsonData loginByGitHub(UserLoginRequest userLoginRequest) {
        return null;
    }

    @Override
    public JsonData loginByLdap(UserLoginRequest userLoginRequest) {
        return null;
    }
}
