# Treinamento Java 8

## Exerc�cios

**1� -** Transforme esse ``Comparator`` em uma express�o lambda. 

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
Mas repare que ainda est� muito verboso.
Conhecendo a API, uma op��o mais interessante � utilizar o ``Integer.compare()``:

````
palavras.sort((s1, s2) -> {
    return Integer.compare(s1.length(), s2.length()); 
});
````
Nesse caso, podemos melhorar ainda mais. Como temos apenas uma instru��o dentro do nosso lambda, podemos remover as chaves, o ponto e v�rgula e a palavra-chave return:

````
palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
````

**2� -** Considere a seguinte ``express?o lambda``:
````
Function<Usuario, String> funcao = u -> u.getNome()
````
Como podemos escrever essa fun�?o com ``method reference``?

**Resposta:**
````
Function<Usuario, String> funcao = u -> u.getNome()
````

**3� -** Modifique a forma que estamos fazendo o sort das palavras utilizando o ``Comparator.comparing()``.

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

**4� -** Crie em seu projeto a seguinte classe Curso:
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

Crie tamb�m uma nova classe com um m�todo main. Nela crie a seguinte lista com alguns cursos:

````
List<Curso> cursos = new ArrayList<Curso>();
cursos.add(new Curso("Python", 45));
cursos.add(new Curso("JavaScript", 150));
cursos.add(new Curso("Java 8", 113));
cursos.add(new Curso("C", 55));
````

Como voc� faria pra ordenar essa lista pela quantidade de alunos?

Voc� pode escolher entre usar um express�o ``lambda`` ou ``method reference``.

**Resposta:**

Com lambda:

````
cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
````
Com method reference:

````
cursos.sort(Comparator.comparingInt(Curso::getAlunos));
````
**5� -** Utilizando a API de Stream, crie um filtro para todos os cursos que tenham mais de 50 alunos.

Depois disso fa�a um forEach no resultado. 

**Resposta:**

````
cursos.stream()
   .filter(c -> c.getAlunos() > 50)
   .forEach(c -> System.out.println(c.getNome()));
````

**6� -** Como transformar o nosso ``Stream<Curso>`` em um ``Stream<String>`` contendo apenas os nomes dos cursos? 

**Resposta:**

````
Stream<String> nomes = cursos.stream().map(Curso::getNome);
````

**7� -** O c�digo a seguir cria um ``Stream<Integer>`` com a quantidade de alunos dos cursos e em seguida imprime todos eles.

````
cursos.stream()
   .filter(c -> c.getAlunos() > 50)
   .map(c -> c.getAlunos())
   .forEach(x -> System.out.println(x));
````

Em que parte desse c�digo podemos tirar proveito da sintaxe de ``method reference``?

**Resposta:**

````
cursos.stream()
   .filter(c -> c.getAlunos() > 50)
   .map(Curso::getAlunos)
   .forEach(System.out::println);
````

**8�** - Calcule a quantidade m�dia de alunos de todos os seus cursos utilizando a API de Stream.

**Resposta**

````
cursos.stream()
    .mapToInt(c -> c.getAlunos())
    .average();
````