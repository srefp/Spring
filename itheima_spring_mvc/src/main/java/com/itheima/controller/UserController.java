package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.VO;
import com.itheima.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-agent") String user_agent) throws IOException {
        System.out.println(user_agent);
    }
    /**
     * 原生的API获取
     *
     * @return
     */
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public String testServlet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("执行了...");
        System.out.println(request);
        HttpSession session = request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        System.out.println(response);
        return "success";
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) {
        System.out.println(date);
    }

    // localhost:8080:/user/quick17/zhangsan
    @RequestMapping(value = "/quick17/{username}")
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name", required = false, defaultValue = "itcast") String username) {
        System.out.println(username);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) {
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(VO vo) {
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs) {
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user) {
        System.out.println(user);
    }

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username, int age) {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("lisi2");
        user.setAge(32);

        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(30);
        //使用json的转换工具
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8() {
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody  //告知SpringMVC框架，不进行试图跳转，直接进行数据响应
    public String save7() {
        return "hello itheima";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello itcast");
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request) {
        request.setAttribute("username", "酷丁鱼");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model) {
        model.addAttribute("username", "博学谷");
        return "success";
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        modelAndView.addObject("username", "itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick2")
    public ModelAndView save2() {
        /*
            Model: 模型 作用是封装数据
            View: 视图 作用是展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据
        modelAndView.addObject("username", "itcast");
        // 设置试图
        modelAndView.setViewName("success");

        return modelAndView;
    }

    // 请求地址 http://localhost:8080/user/quick
    @RequestMapping(value = "/quick", method = RequestMethod.GET, params = {"username"})
    public String save() {
        System.out.println("Controller save running...");
        return "success";
    }
}
