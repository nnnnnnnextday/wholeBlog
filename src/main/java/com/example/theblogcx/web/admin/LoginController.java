package com.example.theblogcx.web.admin;

import com.example.theblogcx.po.User;
import com.example.theblogcx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private UserService userService;

    //跳转到登录页面
    @GetMapping
    public String loginPage(){
        return "admin/login";
    }

    //处理判断登录
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession httpSession, RedirectAttributes redirectAttributes){
        User user = userService.checkUser(username,password);
        if(user!=null){
            httpSession.setAttribute("user",user);
            return "admin/index";
        }else{
            redirectAttributes.addFlashAttribute("message","登陆失败");
            return "redirect:/admin";
        }
    }

    //注销
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/admin";
    }
}
