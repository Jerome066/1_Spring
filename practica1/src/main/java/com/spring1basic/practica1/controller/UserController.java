package com.spring1basic.practica1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring1basic.practica1.model.User;
import org.springframework.ui.Model;


@Controller
public class UserController {

    @GetMapping("/users")
    public String index(Model model) {
        User user1 = new User("Emma", "emma@gmail.com", 1L);
        User user2 = new User("Manuel", "manuel@gmail.com", 2L);
        User user3 = new User("Pame", "pame@gmail.com", 3L);
        List<User> users = List.of(user1,user2,user3);
        model.addAttribute("users", users);
        return "users/index";
    }
    @GetMapping("/users/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        User user1 = new User("Emma", "emma@gmail.com", 1L);
        User user2 = new User("Manuel", "manuel@gmail.com", 2L);
        User user3 = new User("Pame", "pame@gmail.com", 3L);


        return "users/show";
    }

    @GetMapping("/users/create")
    public String create() {
        return "users/create";
    }
    @PostMapping("/users")
    @ResponseBody
    public String store(String name, String email) {
        return "Hola" + name + " tu email es: " + email;
    }
}
