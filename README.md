#Treinamento Java 8


##Streams
A proposta em torno da Streams API é reduzir a preocupação do desenvolvedor com a forma de implementar controle de fluxo ao lidar com coleções, deixando isso a cargo da API. 
A ideia é iterar sobre essas coleções de objetos e, a cada elemento, realizar alguma ação, seja ela de filtragem, mapeamento, transformação, etc. 
Caberá ao desenvolvedor apenas definir qual ação será realizada sobre o objeto.

```
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9 , 0);

//Implementação tradicional
for(Integer n: list) {
   System.out.print(n);
}

//Implementação com expressões lambda e StreamAPI       
list.forEach(n-> System.out.print(n));

```

##ForEach
Percorre uma collection

````
usuarios.stream().forEach(u -> u.tornarVisitante());
//ou
usuarios.stream().forEach(Usuario::tornarVisitante);

````
##Filter
Filtra os elementos de uma collection dada uma condição.

````

````

##RemoveIf
Dado um Predicate, o removeIf vai remover todos os elementos
que devolverem true para esse predicado.

````

````

##Comparator e Sort
Comparar elementos e ordena.  Utiliza a interface java.util.Comparator

````

````

##Map
Caso queira extrair o conteúdo de uma variável

````
````

##Métodos do Optional e cenários de uso

##Métodos streams

##Datas


