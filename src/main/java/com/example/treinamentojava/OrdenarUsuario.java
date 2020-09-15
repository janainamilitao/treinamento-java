package com.example.treinamentojava;

import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;

public class OrdenarUsuario {

    private List<Usuario> usuarios;

    public OrdenarUsuario(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }


    public void porNome(){
        Comparator<Usuario> nameComparator = (u1, u2)->u1.getNome().compareTo(u2.getNome());
        usuarios.sort(nameComparator);

        usuarios.sort(Comparator.comparing(u -> u.getNome())); // Ordenando por nome de forma mais enxuta

        usuarios.sort(Comparator.comparing(Usuario::getNome).reversed()); // Ordenando de forma decrescente

        usuarios.forEach( usuario -> System.out.println(usuario.getNome()));

    }

    public void porPontos(){
        ToIntFunction<Usuario> extraiPontos = u -> u.getPontos();
        Comparator<Usuario> comparator = Comparator.comparingInt(extraiPontos);
        usuarios.sort(comparator);
        usuarios.stream().forEach( usuario -> System.out.println(usuario.getNome()+" ("+usuario.getPontos()+")"));

        usuarios.stream()
                .filter(c -> c.getPontos() > 100)
                .findAny();
    }

}
