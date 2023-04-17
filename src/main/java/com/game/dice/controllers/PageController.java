package com.game.dice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import  com.game.dice.repositories.UserRepository;
import  com.game.dice.models.User;

import java.util.List;

@Controller
@RequestMapping("/page")
public abstract class PageController {

    public @Autowired UserRepository userRepository;
    @Autowired
    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }


}





