package com.academy.controllers;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.model.Aluno;
import com.academy.exceptions.ServiceExceptionThis;
import com.academy.model.Usuario;
import com.academy.service.ServiceUsuario;
import com.academy.util.Util;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {
    @Autowired
	private ServiceUsuario serviceUsuario;
	
	@GetMapping("/")
	public  ModelAndView login() {
		ModelAndView mv = new ModelAndView();
        mv.setViewName("login/login");
        mv.addObject("usuario", new Usuario());
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

	@PostMapping("/login")
	public ModelAndView login(@Valid Usuario usuario, BindingResult br, HttpSession session ) throws NoSuchAlgorithmException, ServiceExceptionThis {
		ModelAndView mv = new ModelAndView();
		mv.addObject("usuario", usuario); // Adiciona o usuário que veio do formulário para repopular em caso de erro
		if(br.hasErrors()) {
			mv.setViewName("login/login");
			return mv;
		}

		Usuario userLogin = serviceUsuario.loginUser(usuario.getEmail(), Util.md5(usuario.getSenha()));
		
		if(userLogin == null) {
			mv.addObject("msg", "Usuário ou senha incorretos. Tente novamente.");
			mv.setViewName("login/login");
		} else {
			session.setAttribute("usuarioLogado", userLogin);
			mv.setViewName("redirect:/index");
		}

		return mv;
	}

	@GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
       // mv.addObject("message", "Welcome to the Academy!");
        mv.addObject("alunoPesquisa", new Aluno());
        
        return mv;
    }

}
