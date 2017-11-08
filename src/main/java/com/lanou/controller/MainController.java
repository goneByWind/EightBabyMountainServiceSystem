package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zar on 2017/11/8.
 */
@Controller
public class MainController {
    @RequestMapping(value = "/home")
    public String home() {
        return "login";
    }
}
