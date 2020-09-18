# Treinamento Java 8

## Exercícios

**1º -** Transforme esse ``Comparator`` em uma expressão lambda. 

````
palavras.sort(new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()) 
            return -1;
        if(s1.length() > s2.length()) 
            return 1;
        return 0;
    }
});
````
**Resposta:**
````
Nosso c?digo fica assim:

palavras.sort((s1, s2) -> {
    if(s1.length() < s2.length()) 
        return -1;
    if(s1.length() > s2.length()) 
        return 1;
    return 0;
});


````
Mas repare que ainda está muito verboso.
Conhecendo a API, uma opção mais interessante é utilizar o ``Integer.compare()``:

````
palavras.sort((s1, s2) -> {
    return Integer.compare(s1.length(), s2.length()); 
});
````
Nesse caso, podemos melhorar ainda mais. Como temos apenas uma instrução dentro do nosso lambda, podemos remover as chaves, o ponto e vírgula e a palavra-chave return:

````
palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
````

**2º -** Considere a seguinte ``express?o lambda``:
````
Function<Usuario, String> funcao = u -> u.getNome()
````
Como podemos escrever essa funç?o com ``method reference``?

**Resposta:**
````
Function<Usuario, String> funcao = u -> u.getNome()
````

**3º -** Modifique a forma que estamos fazendo o sort das palavras utilizando o ``Comparator.comparing()``.

O c?digo atual est? assim:

````
palavras.sort((s1, s2) -> {
    return Integer.compare(s1.length(), s2.length()); 
});
````

**Resposta**:

````
palavras.sort(Comparator.comparing(s -> s.length()));
````

**4º -** Crie em seu projeto a seguinte classe Curso:
````
class Curso {
    private String nome;
    private int alunos;

    public Curso(String nome, int alunos) {
        this.nome = nome;
        this.alunos = alunos;
    }

    public String getNome() {
        return nome;
    }

    public int getAlunos() {
        return alunos;
    }
}
````

Crie também uma nova classe com um método main. Nela crie a seguinte lista com alguns cursos:

````
List<Curso> cursos = new ArrayList<Curso>();
cursos.add(new Curso("Python", 45));
cursos.add(new Curso("JavaScript", 150));
cursos.add(new Curso("Java 8", 113));
cursos.add(new Curso("C", 55));
````

Como você faria pra ordenar essa lista pela quantidade de alunos?

Você pode escolher entre usar um expressão ``lambda`` ou ``method reference``.

**Resposta:**

Com lambda:

````
cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
````
Com method reference:

````
cursos.sort(Comparator.comparingInt(Curso::getAlunos));
````
**5º -** Utilizando a API de Stream, crie um filtro para todos os cursos que tenham mais de 50 alunos.

Depois disso faça um forEach no resultado. 

**Resposta:**

````
cursos.stream()
   .filter(c -> c.getAlunos() > 50)
   .forEach(c -> System.out.println(c.getNome()));
````

**6º -** Como transformar o nosso ``Stream<Curso>`` em um ``Stream<String>`` contendo apenas os nomes dos cursos? 

**Resposta:**

````
Stream<String> nomes = cursos.stream().map(Curso::getNome);
````

**7º -** O código a seguir cria um ``Stream<Integer>`` com a quantidade de alunos dos cursos e em seguida imprime todos eles.

````
cursos.stream()
   .filter(c -> c.getAlunos() > 50)
   .map(c -> c.getAlunos())
   .forEach(x -> System.out.println(x));
````

Em que parte desse código podemos tirar proveito da sintaxe de ``method reference``?

**Resposta:**

````
cursos.stream()
   .filter(c -> c.getAlunos() > 50)
   .map(Curso::getAlunos)
   .forEach(System.out::println);
````

**8º** - Calcule a quantidade média de alunos de todos os seus cursos utilizando a API de Stream.

**Resposta**

````
cursos.stream()
    .mapToInt(c -> c.getAlunos())
    .average();
````