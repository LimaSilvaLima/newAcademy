package com.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.model.Usuario;
import com.academy.repository.UsuarioRepository;

@Controller
public class UsuarioController {
    
	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("/")
	public  ModelAndView login() {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
       // mv.addObject("usuario", new Usuario());
        return mv;
	}

	@GetMapping("/cadastro")
	public  ModelAndView cadastrarUsuario() {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("login/cadastro");
        mv.addObject("usuario", new Usuario());
        return mv;
	}

	@PostMapping("/salvarUsuario")
	public ModelAndView salvarUsuario(Usuario usuario) {	
		ModelAndView mv = new ModelAndView();
		usuarioRepository.save(usuario);
		// Redireciona para a URL raiz ("/") que é mapeada para o método login()
		mv.setViewName("redirect:/");
		return mv;
	};


}
