package com.spring1basic.practica1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring1basic.practica1.model.User;

@Controller
public class WelcomeController {
    @GetMapping // muestra la vista
    // @ResponseBody // Regresa la cadena
    public String welcome(Model model) { // Model nos permite pasar la informacion a nuestra vista 
        model.addAttribute("title", "Welcome to my page");
        
        User user1 = new User("Emma", "emma@gmail.com");
        User user2 = new User("Manuel", "manuel@gmail.com");
        User user3 = new User("Pame", "pame@gmail.com");

        //List<User> users = List.of(user1,user2,user3);
        List<User> users = List.of();// si no hay usuarios

        model.addAttribute("users", users); 

        return "welcome";
    }

    /*
     * @GetMapping("/cursos")
     * 
     * @ResponseBody
     * public String cursos(@RequestParam(required = false) String
     * orden, @RequestParam(required = false) String categoria) { //se espera
     * recibir un parametro llamado "orden" http://localhost:8080/cursos?orden=desc
     * String mensaje = "Lista de cursos";
     * if (orden != null) {
     * mensaje += "Ordenados por: " + orden;
     * }
     * if (categoria != null) {
     * mensaje += "Categoria de: " + categoria;
     * }
     * 
     * return mensaje;
     * }
     */

    @GetMapping("/cursos")
    @ResponseBody
    public List<String> cursos(
        @RequestParam(required = false) List<String> categorias) { // multiples categorias
        

        return categorias;
    }

    // cursos/java
    // Multiple parametros en URL
    @GetMapping({ "/cursos/{curso}", "/cursos/{curso}/{categoria}" })
    @ResponseBody
    public String mostrarCursos(@PathVariable String curso, @PathVariable(required = false) String categoria) {
        if (categoria != null) {
            return "Curso: " + curso + " Categoria: " + categoria;
        }
        return "Curso: " + curso;
    }

}
