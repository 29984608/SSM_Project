package com.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录认证拦截器
 * @author:Yang
 * @date:2018/5/29
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest Request, HttpServletResponse Response, Object o) throws Exception {
        //获取url
        String url = Request.getRequestURI();
        //判断url是否公开地址(实际使用时将公开地址配置在配置文件中)
        //这里公开地址是登录提交的地址
        if(url.indexOf("login")>=0){
            //如果进行登录提交，放行
            return true;
        }
        //判断session
        HttpSession session = Request.getSession();
        String username = (String) session.getAttribute("username");
        if(username != "" && username != null){
            //身份存在放行
            return true;
        }
        //执行到这里，说明用户身份需要认真，跳转登录页面
        Request.getRequestDispatcher("/login.jsp").forward(Request,Response);
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器1.........postHandle");
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("拦截器1.........afterCompletion");
    }
}
