package com.spring1basic.practica1.dto;

import lombok.Getter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //

public class UserDto {
    private String name;
    private String email;
    // se usaron lombok annotations para generar constructor, getters y setters
}