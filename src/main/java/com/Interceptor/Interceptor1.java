package com.Interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:Yang
 * @date:2018/5/29
 */
public class Interceptor1 implements HandlerInterceptor {
    /**
     *进入Handler方法之前执行
     * 用于身份认证，身份授权
     * 比如身份认证，如果认证未通过表示当前用户没有登录，需要此方法拦截不再向下执行
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        /**
         * return false 表示拦截，不再向下执行
         * return true 表示放行
         */
        System.out.println("拦截器1.........preHandle");
        return true;
    }

    /**
     *进入Handler方法之后，返回ModelAndView之前执行
     * 应用场景从modelAndView出发：将公用的模型数据在这里传到视图，也可以统一的指定视图
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("拦截器1.........postHandle");
    }

    /**
     *执行Handler之后执行
     * 统一异常处理，统一日志处理
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("拦截器1.........afterCompletion");
    }
}
