package com.academy.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.academy.model.Aluno;
import com.academy.repository.AlunoRepository;

import jakarta.validation.Valid;


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
    public ModelAndView inserirAlunos(@Valid Aluno aluno, BindingResult br) {
        ModelAndView mv = new ModelAndView();
        if(br.hasErrors()) {
        	mv.setViewName("aluno/formAluno");
        	mv.addObject("aluno", aluno); // Passa o objeto com os erros de volta para a view
        	return mv;
        }
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

    @GetMapping("/filtro-alunos")
    public ModelAndView filtroAlunos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/filtroAlunos");
        return mv;
    }

    @GetMapping("/alunos-ativos")
    public ModelAndView listaAlunosAtivos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-ativos");
        mv.addObject("alunosAtivos", alunoRepository.findByStatusAtivos());
        return mv;
    }

    
    @GetMapping("/alunos-inativos")
    public ModelAndView listaAlunosInativos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-inativos");
        mv.addObject("alunosInativos", alunoRepository.findByStatusInativos());
        return mv;
    }
    @GetMapping("/alunos-concluidos")
    public ModelAndView listaAlunosConcluidos() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-concluidos");
        mv.addObject("alunosConcluidos", alunoRepository.findByStatuscConcluido());
        return mv;
    }

    @GetMapping("/alunos-trancados")
    public ModelAndView listaAlunosTrancados() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/alunos-trancados");
        mv.addObject("alunosTrancados", alunoRepository.findByStatusTrancados());
        return mv;
    }

    @GetMapping("/pesquisar-aluno")
    public ModelAndView pesquisarAluno(@Valid Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("aluno/pesquisarAluno");
        mv.addObject("alunoPesquisa", new Aluno());
        
        return mv;
    }        

    @PostMapping("/pesquisar-aluno-nome")
    public ModelAndView pesquisarAlunoPorNome(@RequestParam(required = false) String nome) {
        ModelAndView mv = new ModelAndView();
        List<Aluno> alunosEncontrados = alunoRepository.findByNomeContainingIgnoreCase(nome);
        if(nome == null || nome.isEmpty() || alunosEncontrados.isEmpty()) {
        	mv.setViewName("aluno/pesquisarAlunoResultado");
        	//mv.addObject("mensagem", "Nenhum aluno encontrado com o nome: " + nome);
            alunosEncontrados = alunoRepository.findAll();
        } else {
            mv.addObject("alunosEncontrados", alunoRepository.findByNomeContainingIgnoreCase(nome));
        }
        mv.setViewName("aluno/pesquisarAlunoResultado");
        mv.addObject("alunosEncontrados", alunosEncontrados);
        return mv;
    }
   

    
        

}
