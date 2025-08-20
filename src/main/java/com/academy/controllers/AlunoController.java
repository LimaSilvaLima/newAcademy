package com.academy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.model.Aluno;


@Controller
public class AlunoController {

    @GetMapping("/inserirAlunos")
    public ModelAndView insertAlunos(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/formAluno");
        mv.addObject("aluno", new Aluno());
        return mv;
    }
    

}
