package com.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.academy.model.Aluno;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {
    
    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home/index");
       // mv.addObject("message", "Welcome to the Academy!");
        mv.addObject("alunoPesquisa", new Aluno());
        
        return mv;
    }

}
