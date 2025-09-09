package com.academy.service;

import java.security.NoSuchAlgorithmException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.exceptions.CriptoExistException;
import com.academy.exceptions.EmailExistsException;
import com.academy.exceptions.ServiceExceptionThis;
import com.academy.model.Aluno;
import com.academy.model.Usuario;
import com.academy.repository.UsuarioRepository;
import com.academy.util.Util;


@Service
public class ServiceUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void salvarUsurio(Usuario user) throws Exception {
        try {
            if(usuarioRepository.findByEmail(user.getEmail()) != null) {
                throw new EmailExistsException("Já existe um usuário com esse email cadastrado." + user.getEmail());
            }
            user.setSenha(Util.md5(user.getSenha()));
            
            
        } catch (NoSuchAlgorithmException e) {
            throw new CriptoExistException("Erro na cripitografia da senha" );
           
        }
        usuarioRepository.save(user);
    }

     

    
public Usuario loginUser(String email, String senha) throws ServiceExceptionThis {
    
    Usuario userLogin = usuarioRepository.buscarLogin(email, senha);
    return userLogin;
    
}


    
}
