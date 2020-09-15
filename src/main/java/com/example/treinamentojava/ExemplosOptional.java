package com.example.treinamentojava;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ExemplosOptional {

    private List<Usuario> usuarios;

    private static final Logger LOGGER = Logger.getLogger(ExemplosOptional.class.getName());

    public ExemplosOptional(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }

    /**
     * Retorna uma instância de Optional vazia.
     */
    public void empty(){
        Optional<Usuario> retorno = Optional.empty();
        LOGGER.info("Optional - empty: "+retorno);
    }

    /**
     * Retorna um Optional com o valor fornecido, mas o valor não pode ser nulo.
     * Se não tiver certeza de que o valor não é nulo use Optional.ofNullable
     */
    public void of(){
        Optional<Usuario> retorno = Optional.of(buscaPorCPF("43512875009"));
        LOGGER.info("Optional - of: "+retorno);
    }

    /**
     * Se um valor estiver presente, retorna um Optional com o valor ,
     * caso contrário, retorna um Optional vazio. Este é um dos métodos mais indicados para criar um Optional
     */
    public void ofNullable(){
        Optional<Usuario> retorno = Optional.ofNullable(buscaPorCPF("45429742007"));
        LOGGER.info("Optional - of: "+retorno);
    }

    /**
     * Retona o maior valor de uma coleção dada uma comparação
     */
    public void max(){
        Optional<Usuario> retorno = usuarios.stream().max(Comparator.comparingInt(Usuario::getPontos));
        LOGGER.info("Optional - max: "+retorno);
    }

    /**
     * Se um valor estiver presente e o valor corresponder ao predicado retorna um Optional com o valor, se não, retorna um Optional vazio:
     */
    public void filter(){
        List<Usuario> retorno = usuarios.stream().filter(u -> !u.getNome().isEmpty()).collect(Collectors.toList());
        LOGGER.info("Optional - filter: "+retorno);
    }

    /**
     * Se um valor estiver presente retorna true, se não, retorna false
     */
    public  void isPresent(){
        Optional<Usuario> usuario = Optional.ofNullable(buscaPorCPF("45429742007"));
        boolean retorno;
        if (usuario.isPresent()){
            retorno = true;
        } else retorno = false;

        LOGGER.info("Optional - isPresent: "+retorno);
    }

    /**
     * Se um valor estiver presente retorna o valor, caso contrário, lança NoSuchElementException.
     * Então para usar get é preciso ter certeza de que o Optional não está vazio.
     */
    public void get(){
        Optional<Usuario> retorno = Optional.ofNullable(buscaPorCPF("45429742007"));

        if (retorno.isPresent()){
            Usuario usuario = retorno.get();
            LOGGER.info("Optional - get: "+usuario);
        }
    }

    /**
     * Se um valor estiver presente, executa a ação no valor, caso contrário, não faz nada
     */
    public void ifPresent(){
        Optional<Usuario> retorno = Optional.ofNullable(buscaPorCPF("45429742007"));
        retorno.ifPresent(Usuario::tornarAdmin);
        LOGGER.info("Optional - ifPresent: "+retorno);

    }

    /**
     * Se um valor estiver presente retorna um Optinal com o resultado da aplicação
     * da função de mapeamento no valor, caso contrário, retorna um Optional vazio.
     */
    public void map(){
        Optional<Usuario> retorno = Optional.ofNullable(buscaPorCPF("45429742007"));

        if (retorno.isPresent()){
           String nome = retorno.map(Usuario::getNome).get();
           LOGGER.info("Optional - get: "+nome);
        }
    }

    /**
     * Se um valor estiver presente, retorna o valor, caso contrário, retorna o valor definido no parâmetro.
     */
    public void orElse(){

       Optional<Usuario> usuario = Optional.ofNullable(usuarios.stream().filter(u -> u.getNome().equals("Teste")).findFirst().orElse(null));

       if(!usuario.isPresent()){
           LOGGER.info("Optional - orElse: DESCONHECIDO");
       }

        LOGGER.info("Optional - orElse:"+usuario.get().getNome());



    }
    public static String iAmStillExecuted(){
        System.out.println("nonEmptyOptional is not NULL,still I am being executed");
        return "I got executed";
    }


    /**
     * Se um valor estiver presente, retorna o valor, caso contrário, retorna o resultado produzido pelo parâmetro.
     */
    public void orElseGet(){
        Optional<String> nome = Optional.of(usuarios.stream()
                .filter(u -> u.getNome().equals("Teste")).findFirst().map(Usuario::getNome).orElseGet(() -> "DESCONHECIDO"));


        LOGGER.info("Optional - orElse:"+nome);
    }

    /**
     * Se um valor estiver presente, retorna o valor, caso contrário, retorna uma exceção
     */
    public void orElseThrow() throws Exception {
        String nomeUsuario = "Teste";
        Optional<String> nome = Optional.of(usuarios.stream()
                .filter(u -> u.getNome().equals(nomeUsuario)).findFirst().map(Usuario::getNome).orElseThrow(() -> new Exception("Usuário não encontrado - " + nomeUsuario)));


        LOGGER.info("Optional - orElse:"+nome);
    }

    private Usuario buscaPorCPF(String cpf){
        return usuarios.stream().filter(usuario -> usuario.getCpf().equals(cpf)).findFirst().orElseGet(null);
    }
}
