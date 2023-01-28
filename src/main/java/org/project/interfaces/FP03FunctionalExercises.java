package org.project.interfaces;

import java.util.List;
import java.util.function.BinaryOperator;

public class FP03FunctionalExercises {
    public static void main(String[] args) {
        List<Integer> listInteger = List.of(1,2,14,13,12,11,16,9,91,13,2,1,21);


        listInteger.stream()
                .reduce(0,Integer::sum);

        /*
         (0,Integer::sum) pertenece al BinaryOperator utilizando el metodo R apply(T var1, U var2);

            Recibe en este caso dos numeros del mismo tipo, opera con ellos y devuelve un valor.
         */

        BinaryOperator<Integer> sumBinaryOperator = Integer::sum;

        BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>(){
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        listInteger.stream()
                .reduce(0, sumBinaryOperator2);


    }
}
