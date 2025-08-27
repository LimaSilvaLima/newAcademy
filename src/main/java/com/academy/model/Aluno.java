package com.academy.model;

import com.academy.enums.Status;
import com.academy.enums.Curso;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
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
//@Table(name = "alunos")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nome")
    @Size(min=5, max = 35, message = "O nome deve ter minimo de 5 caracteres e no máximo 35 caracteres")
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O curso é obrigatório")
    private Curso curso;
    //@Column(name = "matricula", length = 200)
    @NotNull(message = "Click no botão gerar matrícula. é obrigatória")
    private String matricula;
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O status é obrigatório")
    private Status status;
    @Size(min=3, max = 8, message = "O turno deve ter no máximo 8 caracteres")
    @NotBlank(message = "O turno é obrigatório")
    private String turno;
 

}
