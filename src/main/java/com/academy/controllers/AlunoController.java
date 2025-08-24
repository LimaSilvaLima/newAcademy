package com.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import com.academy.model.Aluno;
import com.academy.repository.AlunoRepository;


@Controller
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/inserirAlunos")
    public ModelAndView insertAlunos(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/formAluno");
        mv.addObject("aluno", new Aluno());
        return mv;
    }

    @PostMapping("/InsertAlunos")
    public ModelAndView inserirAlunos(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/aluno/listAlunos");
        alunoRepository.save(aluno);
        return mv;
    }

    @GetMapping("/aluno/listAlunos")
    public ModelAndView listAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/listAlunos");
        mv.addObject("alunos", alunoRepository.findAll());
        return mv;
    }
        

}
