package org.project.streams;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02FunctionalVersion {
    public static void main(String[] args) {

        List<Integer> listInteger = List.of(1,2,14,13,12,11,16,9,91,13,2,1,21);
        List<String> coursesList = List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azue","Docker","Kubernetes");

        addListStructured(listInteger);
        sortedAndDistinctElements(coursesList);

        sortedCustomElements(coursesList);

    }


    private static List<Integer> returnAListOfTitles(List<String> coursesList){
        System.out.println("Return list");
        System.out.println("Return list");
        return coursesList.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }


    private static List<Integer> returnAListOfEvenIntegers(List<Integer> listInteger){

        System.out.println("Return list");
        return listInteger.stream()
                 .filter(x -> x%2 == 0)
                .collect(Collectors.toList());
    }

    private static void sortedCustomElements(List<String> coursesList){
        /**
         * Podemos ordenar de manera customizada con Comparator
         * Dentro definimos el algoritmo de ordenamiento o mejor dicho
         * ¿Porque vamos a ordenar?
         */

        //Orden natural, por default
        System.out.println(" ");
        System.out.println("Natural Order");
        coursesList
                .stream()
                .sorted(Comparator.naturalOrder())
                .forEach(element -> System.out.print(element + " "));

        //Orden reverso al natural
        System.out.println(" ");
        System.out.println("Reverse Order");
        coursesList
                .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(element -> System.out.print(element + " "));

        //Orden customizada y definida por nostros, en este caso por la longitud de cada elemento
        System.out.println(" ");
        System.out.println("Order Custom");
        coursesList
                .stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(element -> System.out.print(element + " "));
    }

    private static void sortedAndDistinctElements(List<String> coursesList){
        /**
         * Sorted es una funcion que ordena la lista, en caso de enteros lo hace por default de menor a mayor,
         * en el caso de strings lo hace alfabeticamente.
         *
         * distinct es una funcion que filta elementos no repetidos
         */

        coursesList.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    private static Integer addListStructured(List<Integer> listNumbers) {

        /*
        Reduce method es aquel metodo que recibe un identify, o identificador (valor inicial)
        tambien recibe un metodo que se encarga de acumular.

        Reduce method, reduce todos los valores en uno solo

        En la primer iteracion a -> 0 y b es el proximo numero, luego b toma el resultado y asi sucesivamente.

        Que pasa cuando el valor que se acumula es menor al identificador? El resultado es el identificador
         */

        return listNumbers.stream()
                 .reduce(0,FP02FunctionalVersion::sum);
    }

    private static Integer sum(int a, int b){
        return a + b;
    }

}
