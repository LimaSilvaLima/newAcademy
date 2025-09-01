package com.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.model.Usuario;

@Controller
public class UsuarioController {
    
	

	@GetMapping("/")
	public  ModelAndView login() {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
       // mv.addObject("usuario", new Usuario());
        return mv;
	}

}
