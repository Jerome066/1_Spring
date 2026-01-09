package com.spring1basic.practica1.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice //todos los controladores tienen la funcion currentUri disponible
public class GlobalModelAttributes {

    @ModelAttribute("currentUri") //lo comparte con todas las vistas con la variable "currentUri"
    public String currentUri(HttpServletRequest request) {
        return request.getRequestURI();
    }
}