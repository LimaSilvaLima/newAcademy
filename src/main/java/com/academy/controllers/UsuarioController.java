package com.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.model.Usuario;
import com.academy.service.ServiceUsuario;

@Controller
public class UsuarioController {
    @Autowired
	private ServiceUsuario serviceUsuario;
	
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
	public ModelAndView salvarUsuario(Usuario usuario) throws Exception {	
		ModelAndView mv = new ModelAndView();
		//usuarioRepository.save(usuario); //enviado para classe ServiceUsuario
		serviceUsuario.salvarUsurio(usuario);
		mv.setViewName("redirect:/");
		return mv;
	}


}
