# PROGRAMACION FUNCIONAL

![blog_lambada_2](https://user-images.githubusercontent.com/56406481/215241078-7550d360-352a-4ff4-9c80-26b14e5d6192.png)


## Porque la gente esta tan loca con la programacion funcional?

Una de las razones de esto es porque se considera un codigo que proporciona **un rendimiento muy eficiente**.

Hoy en dia podemos aprovechar de nuestros procesadores multicore y paralelizar de manera mas sencilla codigo funcional que estructurado.

```
List<String> coursesList = List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azue","Docker","Kubernetes");


courses.stream()
          .peek(System.out::println) 
          .filter(courses -> courses.length() > 11)  //Filtrar solo los cursos con longitud mayor a 11
          .map(String::toUpperCase) //Convertir cada nombre de curso en MAYUSCULA
          .peek(System.out::println)
          .findFirst(); //De todas las posibilidades (Si es que hay) dame el primero
```

```
RESULTADO: 

--Resultado del primer peek --
Spring
Spring Boot
API
Microservices

--Resultado del segundo peek --
MICROSERVICES

--Resultado del find first --

Optional[MICROSERVICES]

```

Lo interesante de este resultado es que en ningun momento chequeó los elementos "AWS","PCF","Azue","Docker","Kubernetes" de la lista.
Esto es precisamente porque estamos pidiendo solamente el primer elemento ``` .findFirst()```.

Lo que ocurre realmente es que, compara cada uno de los elementos y si no cumple con la condicion de filtro entonces sigue aceptando elementos 
(descartando). Cuando encuentra a uno (Microservices) entonces finaliza el peek, finaliza el filter. Comienza el map, mapea solamente MICROSERVICES
para luego iniciar el segundo peek con el unico elemento que es MICROSERVICES y finalmente lo retorna.


## Como JAVA administra esto??

Las operaciones intermedias como peek, filter y map retornan un stream, cada vez que se ejecutan retornan un stream para que puedas aplicar
otra nueva operaciones con los elementos resultantes de la operacion. El elemento findFirst() es una operacion terminal, retorna el resultado
del stream y no permite otra operacion con el. 
Por lo que JAVA, no ejecutara ninguna accion, si no tenemos una operacion terminal que retorne el resultado como FindFirst(), sin el, nada de 
las operaciones intermedias sirven, esto es **porque las operaciones intermedias SON LENTAS**. De esta forma JAVA solo ejecuta el flujo si realmente
hace falta yse hara uso de su resultado. 









