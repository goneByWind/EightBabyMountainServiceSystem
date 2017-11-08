package com.lanou.shiro;

import com.lanou.bean.UserExample;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.omg.CORBA.UserException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 17/11/8.
 */
public class MyRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "ZarAndLxx";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    // 验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        if (!("zhangsan".equals(username))){
            throw new UnknownAccountException("用户名不对");
        }

        String password = new String((char[]) authenticationToken.getCredentials());
        if (!("123".equals(password))){
            throw new IncorrectCredentialsException("密码不对");
        }

        UserExample user = new UserExample();
        user.setUsername(username);
        user.setPassword(password);

        return new SimpleAuthenticationInfo(user,password,getName());
    }
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        /*这个是上面认证时,放在return中的user,好方便*/
        UserExample user = (UserExample) principalCollection.getPrimaryPrincipal();
        // 可以获取user的用户id及各种信息↑

        List<String> perList = Arrays.asList("user:query","user:update");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        for (String per : perList) {
            info.addStringPermission(per);
        }

        return null;
    }
}
