package com.academy.controllers;

import java.util.Optional;
import java.util.UUID; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    

    @PostMapping("/insertAlunos")
    public ModelAndView inserirAlunos(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/aluno/listAlunos");
        alunoRepository.save(aluno);
        return mv;
    }


    @GetMapping("/aluno/listAlunos")
    public ModelAndView listgemAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/listAlunos"); // Corresponde ao arquivo listAlunos.html
        mv.addObject("alunosList", alunoRepository.findAll());
        return mv;
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") UUID id) {
        ModelAndView mv = new ModelAndView();
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            mv.setViewName("aluno/alterarAluno");
            mv.addObject("aluno", alunoOptional.get());
        } else {
            mv.setViewName("redirect:aluno/listAlunos"); // Redireciona se o aluno não for encontrado
        }
        return mv;
    }

    @PostMapping("/alterar")
    public ModelAndView alterar(Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/aluno/listAlunos");
        alunoRepository.save(aluno);
        return mv;
    }

    @GetMapping("/excluir/{id}")
    public ModelAndView excluirAluno(@PathVariable("id") UUID id) {
        ModelAndView mv = new ModelAndView();
        alunoRepository.deleteById(id);
        mv.setViewName("redirect:/aluno/listAlunos");
        return mv;
    }

    


    
        

}
