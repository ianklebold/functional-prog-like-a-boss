package org.project.introduction;

import java.util.List;
public class FP01FunctionalVersion {
    public static void main(String[] args) {
        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
        printEvenNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void printAllNumbersInListFunctional(List<Integer> listNumbers) {
        listNumbers.stream()
                .forEach(FP01FunctionalVersion::print); //Al ser static podemos usar la clase para que llame al metodo
    }

    private static void printEvenNumbersInListFunctional(List<Integer> listNumbers){
        listNumbers.stream()
                .filter(FP01FunctionalVersion::isEven) //Filtra los numeros pares
                .forEach(FP01FunctionalVersion::print); //Por cada elemento hacemos algo
    }


    private static boolean isEven(int number){
        return number%2 == 0;
    }
    private static void print(int number){
        System.out.println(number);
    }
}
