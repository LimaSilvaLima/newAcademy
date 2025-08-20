package com.academy.enums;

public enum Status {
    ATIVO("Ativo"),
    INATIVO("Inativo"),
    TRANCADO("Trancado"),
    CONCLUIDO("Concluído");

    private String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    private Status() {
        // Default constructor for enum
    }
}
