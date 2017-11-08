package com.lanou.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dllo on 17/11/8.
 */
/*SpringMVC的异常处理*/
public class CustomerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {

        ex.printStackTrace();

        CustomerException exception = null;

        // 分类异常信息
        if (ex instanceof CustomerException){
            // shiro的异常
            exception = (CustomerException) ex;
        }else {
            // 其他异常
            exception = new CustomerException("未知错误");
        }

        // 获取异常信息
        String msg = exception.getMessage();

        // 将错误信息放在session域当中
        request.getSession().setAttribute("error_msg",msg);

        // 不用请求转发了,依靠ajax请求转发获得错误信息
        try {
            request.getRequestDispatcher("/WEB-INF/error.html").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
