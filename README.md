#Treinamento Java 8


##Streams
A proposta em torno da Streams API � reduzir a preocupa��o do desenvolvedor com a forma de implementar controle de fluxo ao lidar com cole��es, deixando isso a cargo da API. 
A ideia � iterar sobre essas cole��es de objetos e, a cada elemento, realizar alguma a��o, seja ela de filtragem, mapeamento, transforma��o, etc. 
Caber� ao desenvolvedor apenas definir qual a��o ser� realizada sobre o objeto.

```
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9 , 0);

//Implementa��o tradicional
for(Integer n: list) {
   System.out.print(n);
}

//Implementa��o com express�es lambda e StreamAPI       
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
Filtra os elementos de uma collection dada uma condi��o.

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
Caso queira extrair o conte�do de uma vari�vel

````
````

##M�todos do Optional e cen�rios de uso

##M�todos streams

##Datas


