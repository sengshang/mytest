package edu.soft1.controller;

import edu.soft1.pojo.User;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

@Controller
public class MyController {
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("-----hello-----");
        return "hello";
    }


    @RequestMapping(value = "/param1", method = {RequestMethod.POST})
    public String param1(HttpServletRequest request) {
        //接收client发来的数据
        String name = request.getParameter("name");
        System.out.println("name=" + name);//打印接收过来的数据（参数形式）
        //调用业务层的方法
        //页面跳转
        return "hello";
    }


    @RequestMapping(value = "/param2", method = {RequestMethod.GET, RequestMethod.POST})
    public String param2(HttpServletRequest request, HttpSession session) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println("name=" + name);
        System.out.println("age=" + age);
        session.setAttribute("age", age);
        request.setAttribute("name", name);

        return "hello";
    }


    @RequestMapping(value = "/param3", method = {RequestMethod.POST})
    public String param3(String username, int age) {
        System.out.println("----param3()----");
        System.out.println("username=" + username);
        System.out.println("age=" + age);
        return hello();
    }

    @RequestMapping(value = "/param4.do", method = {RequestMethod.POST})//数据名与方法参数名不同
    public String param4(@RequestParam(value = "username", required = false) String u,
                         @RequestParam(value = "age") int a) {
        System.out.println("----param4()----");
        System.out.println("u=" + u);
        System.out.println("a=" + a);
        return "redirect:test";
    }


    @RequestMapping(value = "/param5", method = {RequestMethod.POST})//数据名与方法参数名不同
    public String param5(User user, HttpSession session) {
        System.out.println("----param5()----");
        System.out.println("username=" + user.getUsername());
        System.out.println("age=" + user.getAge());
        session.setAttribute("name", user.getUsername());
        return "hello";
    }


    @RequestMapping("test")//数据名与方法参数名不同
    public String test() {
        System.out.println("----test()----");
        return "redirect:hello";
    }


    @RequestMapping("reg")//数据名与方法参数名不同
    public String reg(User user) {
        System.out.println("username=" + user.getUsername());
        System.out.println("pwd=" + user.getAge());
        System.out.println("birthday=" + user.getBirthday());
        System.out.println("city=" + user.getAddress().getCity());
        System.out.println("street=" + user.getAddress().getStreet());
        System.out.println("phone=" + user.getAddress().getPhone());
        return "redirect:test";
    }

    @RequestMapping("/delete")//被拦截器拦截的方法(访问路径：/user/delete.do)
    public String delete() {
        System.out.println("----delete()----");
        return "welcome";
    }

    @RequestMapping(value = "/upload2.do", method = {RequestMethod.POST})
    public String fileUpload(MultipartFile[] images, HttpServletRequest request) throws IOException {
        for (MultipartFile image : images) {

            //获取文件的输入流对象
            InputStream is = image.getInputStream();
            //获取文件的真实名字
            String filename = image.getOriginalFilename();
            //在webapp文件夹下，新建一个images的文件夹，作为上传文件的存储位置，这里获取它的真实路径
            String realPath = request.getServletContext().getRealPath("/images");
            System.out.println("上传路径realPath=" + realPath);
            //根据images文件夹的真实路径和文件的名字创建输出流对象
            OutputStream os = new FileOutputStream(new File(realPath, doFileName(filename)));
            //把输入流数据写入输出流,完成文件的上传
            int res = IOUtils.copy(is, os);
            //释放资源，原则：先开后关，后开先关
            System.out.println("上传文件size=" + res + "Byte");
            os.close();
            is.close();
        }
            return "welcome";

        }
        private String doFileName (String fileName){
            //获取文件名的后缀
            String extension = FilenameUtils.getExtension(fileName);
            //获取uuid字符串，避免文件名重复。
            String uuid = UUID.randomUUID().toString();
            System.out.println("上传文件名称=" + uuid);
            return uuid + "." + extension;
        }
    }
