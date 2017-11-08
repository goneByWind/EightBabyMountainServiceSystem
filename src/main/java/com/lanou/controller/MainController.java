package com.lanou.controller;

import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zar on 2017/11/8.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/login")
    public String home() {
        return "login";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
}
