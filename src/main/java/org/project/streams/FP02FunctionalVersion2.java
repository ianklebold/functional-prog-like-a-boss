package org.project.streams;


import java.util.List;

public class FP02FunctionalVersion2 {
    public static void main(String[] args) {

        List<Integer> listInteger = List.of(1,2,14,13,12,11,16,9,91,13,2,1,21);

        addListFunctional1(listInteger);
        addListFunctional2(listInteger);

        System.out.println(findTheMinValue(listInteger));
        System.out.println(findTheMaxValue(listInteger));
    }


    private static Integer addListFunctional1(List<Integer> listNumbers) {

        /*
        Una mejora es a partir de funciones lambda
         */

        return listNumbers.stream()
                 .reduce(0, (x,y) -> x + y );
    }

    private static Integer addListFunctional2(List<Integer> listNumbers) {

        /*
        Una mejora es a partir de referencia a metodos
        el operador colon, puede utilizarse poniendo la clase a la izquierda "::" y luego su metodo.
         */

        return listNumbers.stream()
                .reduce(0, Integer::sum);
    }

    private static Integer findTheMinValue(List<Integer> listNumbers) {

        /*
        La primera iteracion forzamos que el primer value de la lista sea menor que el identificaddor
        Entonces en cada iteracion buscamos el menor valor.
         */
        System.out.println("The minimum value is: ");

        return listNumbers.stream()
                .reduce(Integer.MAX_VALUE, (x,y) -> x>=y?y:x);
    }


    private static Integer findTheMaxValue(List<Integer> listNumbers) {

        /*
        La primera iteracion forzamos que el primer value de la lista sea mayor que el identificaddor
        Entonces en cada iteracion buscamos el menor valor.
         */
        System.out.println("The maximum value is: ");

        return listNumbers.stream()
                .reduce(Integer.MIN_VALUE, (x,y) -> x<=y?y:x);
    }


    private static Integer sum(int a, int b){
        return a + b;
    }

}
