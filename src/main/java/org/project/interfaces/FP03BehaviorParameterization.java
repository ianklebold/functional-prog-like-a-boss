package org.project.interfaces;

import java.util.List;
import java.util.function.Predicate;

public class FP03BehaviorParameterization {
    public static void main(String[] args) {

        /*
        La idea aqui es pasar por parametro codigo, pasar por parametro al propia funcion lambda
         */


        List<Integer> listInteger = List.of(1,2,14,13,12,11,16,9,91,13,2,1,21);

        filterAndPrint(listInteger,x -> x%2 == 0);

        filterAndPrint(listInteger,x -> x%2 != 0);

        //Llevamos la logica a un metodo que recibe un predicado
    }

    private static void filterAndPrint(List<Integer> listInteger, Predicate<Integer> predicate){
        listInteger.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }


}
