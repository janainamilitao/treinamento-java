package com.example.treinamentojava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ExemplosStreams {

    private static final Logger LOGGER = Logger.getLogger(ExemplosStreams.class.getName());

    private List<Usuario> usuarios;

    public ExemplosStreams(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    /**
     * Permite que você encontre qualquer elemento de um Stream.
     */
    public void findAny(){
        Optional<Usuario> usuario = usuarios.stream().filter(u -> u.getPontos() > 100).findAny();
        LOGGER.info("Streams - findAny: "+usuario.orElseGet(null).getNome());
    }

    /**
     * Encontra o primeiro elemento de um stream.
     */
    public void findFirst(){
        Optional<Usuario> usuario = usuarios.stream().filter(c -> c.getPontos() > 200).findFirst();
        LOGGER.info("Streams - findFirst: "+usuario.orElseGet(null).getNome());
    }

    /**
     * Retorna quantidade de elementos num stream
     */
    public void count(){
       long count = usuarios.stream().count();
        LOGGER.info("Streams - count: "+count);
    }

    /**
     * Realiza tarefa de redução  como a soma de números armezados numa lista ou concatenar uma string
     */
    public void reduce(){
        //Uma simples operação de soma
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }


        LOGGER.info("Streams - Soma Simples: "+sum);


        int somaReduce = numbers.stream().reduce(0, (subtotal, element) -> subtotal + element);
        LOGGER.info("Streams - soma reduce: "+sum);

        String[] myArray = { "Aprendendo", " Java", " 8"};
        String result = Arrays.stream(myArray)
                .reduce("", (a,b) -> a + b);

        LOGGER.info("Streams - concatenando reduce: "+result);


    }

    /***
     * Retorna true se todos os elementos do fluxo corresponde ao predicado fornecido.
     */
    public void allMatch(){
        boolean resultado = usuarios.stream().allMatch(usuario -> usuario.getTipoUsuario().equals(TipoUsuario.VISITANTE));
        LOGGER.info("Streams - allMatch: "+resultado);
    }

    /**
     * Retorna true se qualquer um dos elementos do fluxo corresponde ao predicado fornecido
     */
    public void anyMatch(){
        boolean resultado = usuarios.stream().anyMatch(usuario -> usuario.getTipoUsuario().equals(TipoUsuario.MODERADOR));
        LOGGER.info("Streams - anyMatch: "+resultado);
    }

    /**
     * Retorna true se nenhum dos elementos do fluxo corresponde ao predicado fornecido.
     */
    public void noneMatch(){
        boolean resultado = usuarios.stream().noneMatch(usuario -> usuario.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR));
        LOGGER.info("Streams - noneMatch: "+resultado);
    }

    /**
     * Determina a quantidade de registros da lista
     */
    public void limit(){
       List<Usuario> list = usuarios.stream().limit(2).collect(Collectors.toList());
       LOGGER.info("Streams - limit: "+ list.stream().map(usuario -> usuario.getNome()).collect(Collectors.toList()));
    }

}
