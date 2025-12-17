package com.spring1basic.practica1.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WelcomeController {
    @GetMapping
    //@ResponseBody // Regresa la cadena
    public String welcome(){
        return "Welcome";
    }

    @GetMapping("/cursos")
    public String cursos(){
        return "Cursos";
    }
}
