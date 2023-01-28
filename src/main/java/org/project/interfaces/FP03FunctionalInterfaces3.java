package org.project.interfaces;

import java.util.function.*;

public class FP03FunctionalInterfaces3 {
    public static void main(String[] args) {

        //Unary Operator
        /*
        Tiene una entrada de un tipo T y una salida de tipo T
        Tipicamente existen unary operator que permiten convertir de un tipo a otro
         */
        UnaryOperator<Integer> unaryOperator = (x) -> x*3;
        System.out.println(unaryOperator.apply(50));


        //Supplier
        /*
        Supplier no recibe nada por parametro y solo retorna algo, por ejemplo un numero random

         */
        Supplier<Integer> supplierExample = () -> 2;
        System.out.println(supplierExample.get());


        //BiPredicate
        /*
        BiPredicate tiene  como entrada dos datos (pueden ser de distinto tipo) y una salida de tipo boolean.
         */
        BiPredicate<Integer,String> biPredicate = (x,y) -> x > Integer.valueOf(y);
        System.out.println(biPredicate.test(5,"10"));



        //BiFunction
        /*
        BiFunction tiene como entrada dos datos (pueden ser de distintos tipos) y una salida la cual hay que aclarar
        En el siguiente ejemplo, la salida sera el ultimo argumento osea un string
         */
        BiFunction<String,Integer,String> biFunction = (x,y) -> {
            return y + " " + x;
        };
        System.out.println(biFunction.apply("Hola tengo : ",23));

        //BiConsumer
        /*
        BiConsumer tiene como entrada dos datos (pueden ser distintos tipos) y no devuelve nada simplemente hace algo
         */

        BiConsumer<String,Integer> biConsumer = (x,y) -> {
            System.out.println(x + " " + y);
        };

        biConsumer.accept("Tengo :", 50);


        /**
         * Es preferible simpre usar datos primitivos y no las Wrapper class Integer, String, etc
         * Por ejemplo podemos usar la siguiente, que sera equivalente a BiPredicate pero con datos primitivos
         */

        IntBinaryOperator intPredicate = (x,y) -> x + y;

        System.out.println(intPredicate.applyAsInt(5,5));

        /*
        Podemos indicar en los binaryOperators los tipos de los parametros, pero si indicamos en uno de ellos,
        obligatoriamente debemos indicarlo en el otro.

        Sin emabargo no es obligatoria, ya que implicitamente Por ejemplo en IntBinaryOperator se destina un espacio
        de dos integers, en el caso de BinaryOperator se indica en el argumento de la funcion, por lo que no hay necesidad de aclarar
         */

        IntBinaryOperator intPredicate2 = (int x, int y) -> x + y;

        System.out.println(intPredicate2.applyAsInt(2,5));

    }
}
