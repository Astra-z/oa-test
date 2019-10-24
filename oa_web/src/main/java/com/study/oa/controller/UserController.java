package com.study.oa.controller;

import com.study.oa.biz.UserBiz;
import com.study.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String Login(RedirectAttributes model,HttpSession session, @RequestParam String sn, @RequestParam String password){
        Employee e=userBiz.login(sn,password);
        if (e==null){
            model.addFlashAttribute("message","账号或密码错误！请重试!");
            return "redirect:to_login";
        }
        else{
            session.setAttribute("employee",e);
            return "redirect:info";
        }
    }

    @RequestMapping("/info")
    public String user_info(){
        return "self";
    }

    @RequestMapping("/quit")
    public String Logout(HttpSession session){
        session.removeAttribute("employee");
        return "redirect:to_login";
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "change_password";
    }

    @RequestMapping("change_password")
    public String changePassword(HttpSession session,RedirectAttributes model,
            @RequestParam("old") String oldpassword,
            @RequestParam("new1")String newpassword1,
            @RequestParam("new2")String newpassword2){

        Employee employee= (Employee) session.getAttribute("employee");
        if(!employee.getPassword().equals(oldpassword)) {
            model.addFlashAttribute("message","原密码错误！");
            return "redirect:to_change_password";
        }
        else if (!newpassword1.equals(newpassword2)){
            model.addFlashAttribute("message","两次输入的密码不一致！");
            return "redirect:to_change_password";
        }
        else {
            employee.setPassword(newpassword1);
            userBiz.changePassword(employee);
            return "redirect:info";
        }
    }
}
