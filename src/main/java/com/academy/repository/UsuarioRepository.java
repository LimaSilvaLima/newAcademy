package com.academy.repository;

import java.util.UUID;

import org.hibernate.service.spi.ServiceException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.academy.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID> {

        @Query("SELECT u FROM Usuario u WHERE u.email = :email")
        public Usuario findByEmail(String email);
        //public List<Usuario> findByEmail(String email);

        @Query("SELECT u FROM Usuario u WHERE u.nomeusuario = :usuario AND u.senha = :senha")
        public Usuario buscarLogin (String usuario, String senha);

}


