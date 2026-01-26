package com.spring1basic.practica1.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring1basic.practica1.dto.UserDto;
import com.spring1basic.practica1.model.User;
import com.spring1basic.practica1.repository.UserRepository;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public String index(Model model) {
        // User user1 =
        // User.builder().id(1L).name("Emma").email("emma@gmail.com").build();
        // User user2 =
        // User.builder().id(2L).name("Manuel").email("manuel@gmail.com").build();
        // User user3 =
        // User.builder().id(3L).name("Pame").email("pame@gmail.com").build();
        // List<User> users = List.of(user1, user2, user3);

        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);
        return "users/index";
    }

    // @GetMapping("/users")
    // public String index(Model model) {
    // User user1 = new User("Emma", "emma@gmail.com", 1L);
    // User user2 = new User("Manuel", "manuel@gmail.com", 2L);
    // User user3 = new User("Pame", "pame@gmail.com", 3L);
    // List<User> users = List.of(user1, user2, user3);
    // model.addAttribute("users", users);
    // return "users/index";
    // }

    @GetMapping("/users/{id}")
    public String show(Model model, @PathVariable("id") Long id) {
        User user1 = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user1);

        return "users/show";
    }

    @GetMapping("/users/create")
    public String create(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "users/create";
    }
    // @PostMapping("/users")
    // @ResponseBody
    // public User store(@ModelAttribute User user) { //@ModelAttribute hace el
    // mapeo automatico de los datos del formulario a el objeto user
    // return user;
    // }

    @GetMapping("/users/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/users/update/{id}")
    public String update(@PathVariable Long id, Model model) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        UserDto userDTO = new UserDto();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());

        model.addAttribute("userDTO", userDTO);
        model.addAttribute("userId", id);

        return "users/update";
    }

    @PostMapping("/users")
    // @ResponseBody
    public String store(@Valid @ModelAttribute UserDto userDTO, // @Valid valida los datos del formulario segun las
                                                                // anotaciones en UserDto
            BindingResult result, // BindingResult contiene los resultados de la validacion
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("userDTO", userDTO);
            return "users/create";
        }

        // User user = new User();
        // user.setName(userDTO.getName());
        // user.setEmail(userDTO.getEmail());

        // Patron Builder
        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .build();

        userRepository.save(user); // persiste el usuario en la base de datos / persistencia de datos

        return "redirect:/users"; // redirige a la ruta /users
    }

}
