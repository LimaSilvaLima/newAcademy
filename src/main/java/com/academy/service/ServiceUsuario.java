package com.academy.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.exceptions.CriptoExistException;
import com.academy.exceptions.EmailExistsException;
import com.academy.model.Aluno;
import com.academy.model.Usuario;
import com.academy.repository.UsuarioRepository;
import com.academy.util.Util;


@Service
public class ServiceUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void salvarUsurio(Usuario usuario) throws Exception {
        try {
            if(usuarioRepository.findByEmail(usuario.getEmail()) != null) {
                throw new EmailExistsException("Já existe um usuário com esse email cadastrado." + usuario.getEmail());
            }
            usuario.setSenha(Util.md5(usuario.getSenha()));
            
            
        } catch (NoSuchAlgorithmException e) {
            throw new CriptoExistException("Erro na cripitografia da senha" );
           
        }
        usuarioRepository.save(usuario);
    }

    public void salvarAluno(Aluno aluno) {
        // Lógica para salvar o aluno
    }   
}
