package com.lanou.exception;

import com.lanou.utils.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by dllo on 17/11/8.
 */
@Controller
public class ExceptionController {

    // 获得session域中的错误信息
    @RequestMapping(value = "/getErrorMsg")
    public AjaxResult getErrorMsg(HttpServletRequest request){

        String errorMsg = (String) request.getSession().getAttribute("error_msg");

        return new AjaxResult(errorMsg);
    }
}
