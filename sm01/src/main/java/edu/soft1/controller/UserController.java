package edu.soft1.controller;

import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerOutput;
import edu.soft1.pojo.User;
import org.immutables.value.internal.$processor$.meta.$ValueMirrors;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/login")
    public String login(User user, HttpSession session){
        System.out.println("----login()----");//进入控制器方法
        int flag = 0;//调用业务层（业务层调用dao层），获取flag的值
        if (flag == 0){
            System.out.println("username="+user.getUsername());
//            session.setMaxInactiveInterval(10);//10秒钟有效期
            session.setAttribute("user",user);//登录对象放入session
            return "welcome";//登录成功
        }
        return "redirect:/index";//登录失败，跳转回首页
    }

    @RequestMapping("/delete")//被拦截器拦截的方法
    public String delete(HttpServletRequest request){
        System.out.println("----执行delete()成功！----");
        request.setAttribute("CRUDmsg","删除功能执行完毕！");
        return "hello";
    }

    @RequestMapping("/welcome")//转至欢迎页面
    public String welcome(){
        System.out.println("----welcome()----");
        return "welcome";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session){
        session.invalidate();//清除session
        System.out.println("已登出");
         return "redirect:/index.jsp";
    }

    @RequestMapping("/user.do")
    public String use(){
        System.out.println("---用户管理--");
        return "redirect:/user";
    }



    @RequestMapping(value = "/upload2.do",method = {RequestMethod.POST})
    public String fileUpload2(MultipartFile[] images,HttpServletRequest request) throws IOException{
        InputStream is = null;
        OutputStream os = null;
        for (MultipartFile image :images){
            is= image.getInputStream();//获取文件的输入流对象
            String filename = image.getOriginalFilename();//获取文件的真实名字
            System.out.println("文件原名称="+filename);
            if(filename.equals("")){
                System.out.println("空字符串，进入下一轮循环");
                continue;//进入下一轮循环
            }
            String realPath = request.getServletContext().getRealPath("/images");
            System.out.println("上传路径realPath="+realPath);
            os = new FilterOutputStream(new File(realPath,))
        }
    }
}
