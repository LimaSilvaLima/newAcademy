package com.academy.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academy.model.Aluno;

public interface AlunoRepository  extends JpaRepository<Aluno, UUID> {

    @Query("SELECT a FROM Aluno a WHERE a.status = 'ATIVO'")
    public List<Aluno> findByStatusAtivos();


    @Query("SELECT a FROM Aluno a WHERE a.status = 'TRANCADO'")
    public List<Aluno> findByStatusTrancados();

    @Query("SELECT a FROM Aluno a WHERE a.status = 'INATIVO'")
    public List<Aluno> findByStatusInativos();  

    @Query("SELECT a FROM Aluno a WHERE a.status = 'CONCLUIDO'")
    public List<Aluno> findByStatuscConcluido();


}
