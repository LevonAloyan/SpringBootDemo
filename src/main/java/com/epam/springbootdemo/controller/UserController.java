package com.epam.springbootdemo.controller;

import com.epam.springbootdemo.model.User;
import com.epam.springbootdemo.model.UserLogin;
import com.epam.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String sayHello(@PathVariable("id") Long id, Model model) {

        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute UserLogin userLogin, Model model) {

        User user = userService.getByEmailAndPassword(userLogin.getUsername(), userLogin.getPassword());
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }


}
