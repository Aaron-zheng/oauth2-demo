package com.sightcorner.oauth.service;


import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.domain.client.ClientInfo;
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

            boolean reAuth = Boolean.parseBoolean(httpServletRequest.getParameter("reAuth"));

            ClientInfo clientInfo;
            //验证该请求的clientId，如果不存在，则是“应用未注册”
            //验证该请求的redirectURI，如果与之前应用注册的重定向URI不一样，则是“错误的重定向资源标识符”
            //验证该请求的grantType，如果与之前应用注册的授权类型不一样，则是“不支持的授权类型”
            //验证该请求的scope，如果与之前应用注册的作用域不一样，则是“无效作用域”
            //验证该请求的scope，如果作用域中含有非认证中心的，则是“只允许传递认证中心内部作用域”


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
