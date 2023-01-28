package org.project.interfaces;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterizationExercises {
    public static void main(String[] args) {

        /*
        La idea aqui es pasar por parametro codigo, pasar por parametro al propia funcion lambda
         */

        List<Integer> listInteger = List.of(1,2,14,13,12,11,16,9,91,13,2,1,21);

        mappingAndCreateList(listInteger,x -> x * x);
        mappingAndCreateList(listInteger,x -> x * x * x);
        mappingAndCreateList(listInteger,x -> x * x * x * x);

        //Llevamos la logica a un metodo que recibe un predicado
    }

    private static List<Integer> mappingAndCreateList(List<Integer> listInteger, Function<Integer,Integer> function){
        return listInteger.stream()
                .map(function)
                .collect(Collectors.toList());
    }


}
