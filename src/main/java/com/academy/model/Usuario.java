package com.academy.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity

public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Size(min=5, max = 35, message = "O usuario deve ter minimo de 5 caracteres e no máximo 35 caracteres")
    @NotBlank(message = "O usuario é obrigatório")
    private String nomeusuario;
    @Email(message = "Email inválido")
    @NotBlank(message = "O email é obrigatório")
    private String email;
    private String senha;

    
}
