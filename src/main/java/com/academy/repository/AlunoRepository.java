package com.academy.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.academy.model.Aluno;

public interface AlunoRepository  extends JpaRepository<Aluno, UUID> {
    
    

}
