package com.example.treinamentojava;

public class Usuario {

    private String nome;
    private int pontos;
    private TipoUsuario tipoUsuario;


    public Usuario(String nome, int points) {
        this.nome = nome;
        this.pontos = points;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void tornarModerador() {
        this.tipoUsuario = TipoUsuario.MODERADOR;
    }

    public void tornarAdmin() {
        this.tipoUsuario = TipoUsuario.ADMINISTRADOR;
    }

    public void tornarVisitante(){ this.tipoUsuario = TipoUsuario.VISITANTE; }
}
