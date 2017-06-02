package com.sightcorner.oauth.web;


import com.sightcorner.oauth.service.AuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("oauth")
public class AuthorizeController {

    @Autowired
    private AuthorizeService authorizeService;


    @RequestMapping(value = "authorize")
    public Object authorize() {


        return null;
    }

}
