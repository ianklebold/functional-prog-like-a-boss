package org.project.interfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces2 {


    public static void main(String[] args) {
        List<Integer> listInteger = List.of(1,2,14,13,12,11,16,9,91,13,2,1,21);


        /*
        Lo que vemos a continuacion es lo que ocurre dentro de cada funcion filter, map y for each
         */

        /*
        Internamente un Predicate tiene un metodo que lo que permite hacer es implementar el que querramos
        --> boolean test(T var1);

        Su trabajo es testear algo y devolver un valor booleano
         */

        Predicate<Integer> isEvenPredicate = x -> x%2 == 0;

        //Por detras tambien se puede escribir como:
        //Funcion anonima
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2 == 0;
            }
        };

        /*
        Internamente una Funcion acepta un argumento y produce una salida

        x -> x * x; 1 input and 1 output

        --> R apply(T var1);
         */


        Function<Integer,Integer> squareFunction = x -> x * x;

        //Funcion anonima
        Function<Integer,Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        /*
        Internamente un Consumidor acepta un argumento y no produce ninguna salida, simplemente hace algo con la entrada
        y nada mas.

        -->void accept(T var1);
         */

        Consumer<Integer> sysoutConsumer = System.out::println;

        //Funcion anonima
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };

        System.out.println("Primera salida: ");
        listInteger.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);

        System.out.println("Segunda salida: ");
        listInteger.stream()
                .filter(isEvenPredicate2)
                .map(squareFunction2)
                .forEach(sysoutConsumer2);
    }

}
