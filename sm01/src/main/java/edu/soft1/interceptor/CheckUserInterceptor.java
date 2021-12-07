package edu.soft1.interceptor;

import edu.soft1.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CheckUserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response ,Object o)throws Exception{
        HttpSession session = request.getSession();
        Object obj = session.getAttribute("user");//获取session中的登录对象
//        User user = (User) session.getAttribute("user");//null
        if (obj != null && obj instanceof User) {
            System.out.println("拦截器放行");
            return true;//拦截器放行，通过
        }

        request.getRequestDispatcher("/index.jsp").forward(request,response);//跳转(转发)登录页
//        response.sendRedirect("/index.jsp");//跳转(重定向)登录页
        System.out.println("被拦截，返回登录页");
        return false;//被拦截
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


}
