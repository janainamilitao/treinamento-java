package com.example.treinamentojava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@SpringBootApplication
public class TreinamentoJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoJavaApplication.class, args);

		List<Usuario> usuarios = criarUsuarios();

		exemplo_ForEach(usuarios);
		exemplo_Filter(usuarios);
		exemplo_RemoveIf(usuarios);
		exemplo_Comparator_Sort(usuarios);
		exemplo_Map(usuarios);
		exemplo_Average(usuarios);
	}

	/**
	 * AVERAGE: Calcular média
	 * @param usuarios
	 */
	private static void exemplo_Average(List<Usuario> usuarios){
		System.out.println("<=== Exemplo: average");
		double pontuacaoMedia = usuarios.stream()
										.mapToInt(Usuario::getPontos)
										.average()
										.getAsDouble();
		System.out.println("Pontuação Média:"+pontuacaoMedia);
	}

	/**
	 * MAP: Extrair o conteúdo de uma variável
	 * @param usuarios
	 */
	private static void exemplo_Map(List<Usuario> usuarios){
		System.out.println("<=== Exemplo: Lista de pontos dos usuários");
		List<Integer> points = usuarios.stream().map(Usuario::getPontos).collect(toList());
		System.out.println(points);
	}

	/**
	 * SORT: Ordenada elementos de uma collection
	 * @param usuarios
	 */
	private static void exemplo_Comparator_Sort(List<Usuario> usuarios){
		System.out.println("<=== Exemplo: Comparator e Sort");
		exemplo_ComparatorPoints(usuarios);
		exemplo_ComparatorNames(usuarios);
	}


	private static void exemplo_ComparatorPoints(List<Usuario> usuarios){
		System.out.println("<=== Exemplo: Lista usuários ordenados por pontos");
		ToIntFunction<Usuario> extraiPontos = u -> u.getPontos();
		Comparator<Usuario> comparator = Comparator.comparingInt(extraiPontos);
		usuarios.sort(comparator);
		usuarios.stream().forEach( usuario -> System.out.println(usuario.getNome()+" ("+usuario.getPontos()+")"));
	}

	private static void exemplo_ComparatorNames(List<Usuario> usuarios){
		System.out.println("<=== Exemplo: Lista usuários ordenados por nomes");
		Comparator<Usuario> nameComparator = (u1, u2)->u1.getNome().compareTo(u2.getNome());
		usuarios.sort(nameComparator);

		usuarios.sort(Comparator.comparing(u -> u.getNome())); // Ordenando por nome de forma mais enxuta

		usuarios.sort(Comparator.comparing(Usuario::getNome).reversed()); // Ordenando de forma decrescente

		usuarios.forEach( usuario -> System.out.println(usuario.getNome()));
	}

	/***
	 * REMOVEIF: Remove todos os elemetos de uma collection que devolverem true dado uma condição
	 * Há um detalhe aqui: o removeIf invoca o remove de uma coleção, então ela
	 * não pode ser imutável, ou um UnsupportedOperationException será lançado.
	 */
	private static void exemplo_RemoveIf(List<Usuario> usuarios){
		System.out.println("<=== Exemplo: Remover numeros pares");
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		numbers.removeIf( number -> number%2 == 0 );
		System.out.println(numbers);

		System.out.println("<=== Exemplo: Remover usuário do tipo MODERADOR");
		List<Usuario> usuarioList = new ArrayList<>(usuarios);
		usuarioList.removeIf(u -> u.getTipoUsuario().equals(TipoUsuario.MODERADOR));
		usuarioList.stream().forEach( u -> System.out.println(u.getNome()+" ("+u.getPontos()+") - "+ u.getTipoUsuario().toString()));
	}

	/***
	 * Filter: filtra elementos de uma collection dada uma condição
	 * @param usuarios
	 */
	private static void  exemplo_Filter(List<Usuario> usuarios){
		System.out.println("<===Exemplo: Filter -> tornar modenador apenas os usuários com 100 pontos ===>");

		List<Usuario> moderadores1 = new ArrayList<Usuario>();
		usuarios.stream().filter(u -> u.getPontos()== 100).
				forEach( usuario -> {
					moderadores1.add(usuario);
					usuario.tornarModerador();
				});

		List<Usuario> moderadores2 = usuarios.stream().filter(u -> u.getPontos()== 100).collect(toList());

		moderadores2.stream().forEach( u -> System.out.println(u.getNome()+" ("+u.getPontos()+") - "+ u.getTipoUsuario().toString()));
	}

	/***
	 * FOREACH: Itera uma colecction
	 * @param usuarios
	 */
	private static void exemplo_ForEach(List<Usuario> usuarios){
		System.out.println("<=== Exemplo: ForEach -> tornar todos os usuários visitantes ===>");
		usuarios.stream().forEach(u -> u.tornarVisitante());
		//ou
		usuarios.stream().forEach(Usuario::tornarVisitante);
		usuarios.stream().forEach( u -> System.out.println(u.getNome()+" ("+u.getPontos()+") - "+ u.getTipoUsuario().toString()));
	}

	private static  List<Usuario> criarUsuarios(){
		System.out.println("<==================================================================>");
		System.out.println("<=============== JAVA 8 - LAMBDAS E STREAMS =======================>");
		System.out.println("<==================================================================>");


		Usuario usuario1 = new Usuario("Janaina Militão", 200);
		Usuario usuario2 = new Usuario("Aécio Rafael",  100);
		Usuario usuario3 = new Usuario("Rodrigo Trombeta", 300);
		Usuario usuario4 = new Usuario("Amanda Silva", 100);
		Usuario usuario5 = new Usuario("Daniel Lucas", 100);


		List<Usuario> usuarios = Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5);

		return usuarios;
	}
}
