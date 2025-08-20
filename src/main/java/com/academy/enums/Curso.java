package com.academy.enums;

public enum Curso {

    ADMINISTRAÇCAO("Administração"),
    CIENCIAS_CONTABEIS("Ciências Contábeis"),
    DIREITO("Direito"),
    ENGENHARIA_CIVIL("Engenharia Civil"),
    ENGENHARIA_DE_SOFTWARE("Engenharia de Software"),
    ENGENHARIA_ELETRICA("Engenharia Elétrica"),
    ENGENHARIA_MECANICA("Engenharia Mecânica"),
    ENGENHARIA_QUIMICA("Engenharia Química");

    private String curso;
    
    Curso(String curso) {
        this.curso = curso;
    }
    public String getCurso() {
        return curso;
    } 
    private Curso() {
        // Default constructor for enum
    }      

}
