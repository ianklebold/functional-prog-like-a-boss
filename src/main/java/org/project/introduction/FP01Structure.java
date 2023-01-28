package org.project.introduction;


import java.util.List;

public class FP01Structure {
    public static void main(String[] args) {

        printAllNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
        printEvenNumbersInListStructured(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void printAllNumbersInListStructured(List<Integer> listNumbers) {
        for (int number:listNumbers){
            System.out.println(number);
        }
    }

    private static void printEvenNumbersInListStructured(List<Integer> listNumbers){
        for (int number:listNumbers){
            if(number % 2 == 0)
                System.out.println(number);
        }
    }
}
