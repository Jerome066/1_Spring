package com.spring1basic.practica1.dto;

import lombok.Getter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // para usar el patron builder

public class UserDto {
    @NotBlank(message = "El nombre no puede estar vacío") //la variable name no puede estar vacia
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres") //la variable name debe tener entre 2 y 50 caracteres
    private String name;

    @NotBlank(message = "El email no puede estar vacío") //la variable email no puede estar vacia
    @Email(message = "El email debe tener un formato válido") //la variable email debe tener un formato valido
    private String email;
    // se usaron lombok annotations para generar constructor, getters y setters
}