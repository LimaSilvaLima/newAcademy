package com.academy.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.academy.model.Usuario;
import java.util.List;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID> {

        @Query("SELECT u FROM Usuario u WHERE u.email = :email")
        public Usuario findByEmail(String email);
        //public List<Usuario> findByEmail(String email);
}
