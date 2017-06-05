package com.sightcorner.oauth.service;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class AuthorizeImpl implements AuthorizeService {



    public void authorize(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {


        try {
            OAuthAuthzRequest oAuthAuthzRequest = new OAuthAuthzRequest(httpServletRequest);
            String clientId = oAuthAuthzRequest.getClientId();//应用id
            String redirectURI = oAuthAuthzRequest.getRedirectURI();//重定向
            String responseType = oAuthAuthzRequest.getResponseType();//
            String scope = oAuthAuthzRequest.getParam(OAuth.OAUTH_SCOPE);

            //重新授权标识
            boolean reAuth = Boolean.parseBoolean(httpServletRequest.getParameter("reAuth"));


            ////////////////////////////////////////////////////////////////////////
            //根据 clientId，从数据库中获得 clientInfo，包含 redirectURI, grantType, scope
            //验证该请求的 clientId，如果不存在，则是“应用未注册”
            //验证该请求的 redirectURI，如果与之前应用注册的重定向URI不一样，则是“错误的重定向资源标识符”
            //验证该请求的 grantType，如果与之前应用注册的授权类型不一样，则是“不支持的授权类型”
            //验证该请求的 scope，如果与之前应用注册的作用域不一样，则是“无效作用域”
            //验证该请求的 scope，如果作用域中含有非认证中心的，则是“只允许传递认证中心内部作用域”


            ////////////////////////////////////////////////////////////////////////
            //快速登录
            //根据 clientId，从缓存中获得，缓存密码
            //根据该请求的 accountId，从数据库中获得，数据库密码
            //验证快速登录下该请求的 accountId，如果不存在，则是“帐号不存在”
            //验证快速登录下该请求的 accountId，如果状态为冻结，则是“帐号被冻结”
            //验证快速登录下该请求的 accountId，如果状态为异常，则是“帐号异常”
            //验证快速登录下该请求的 缓存密码 和 数据库密码，如果是不相等，则是“帐号密码已修改，需重新登录”


            ////////////////////////////////////////////////////////////////////////
            //普通登录
            //根据 username，从数据库中获得，accountId, accountStatus
            //验证该请求的 username，如果为空，则是“用户名不能为空”
            //验证该请求的 username，如果不存在，则是“用户名不存在”
            //验证该请求的 accountId 和 clientId，如果不存在，则是“帐号没权限登录应用”
            //验证该请求的 accountStatus，如果状态为冻结，则是“帐号被冻结”
            //验证该请求的 accountStatus，如果状态为异常，则是“帐号异常”
            //验证该请求的 password，如果与数据库的不想等，则是“密码错误”


            ////////////////////////////////////////////////////////////////////////
            //openId 由 accountId 和 clientId 的信息摘要得出
            //登录页面 reAuth = false, 授权页面 reAuth = true
            //根据openId，clientInfo, reAuth 得出是否需要重新授权
            //更新 clientInfo 中的多个 clientResource.flag （标记此资源是否被授权）
            //一个 clientInfo 有多个 scope，每个 scope 包含多个 clientResource


            //当 responseType 为 token 时候，则返回 token
            //根据 ，生成一个 token
            //在缓存中，存储 token.getUserClientRel，token，expire

            //当 responseType 为 code 时候，则返回 code



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
