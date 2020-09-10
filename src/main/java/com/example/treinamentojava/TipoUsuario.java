package com.example.treinamentojava;

public enum TipoUsuario {

    VISITANTE(1),
    MODERADOR(2),
    ADMINISTRADOR(3);

    private int tipo;

    TipoUsuario(int type){
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }
}