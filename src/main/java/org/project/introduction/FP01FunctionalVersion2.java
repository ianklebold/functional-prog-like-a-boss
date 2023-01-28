package org.project.introduction;

import java.util.List;
public class FP01FunctionalVersion2 {
    public static void main(String[] args) {
        printAllNumbersInListFunctional(List.of(12,9,13,4,6,2,4,12,15));
    }

    private static void printAllNumbersInListFunctional(List<Integer> listNumbers) {
        //System.out es una clase static, por lo que podemos dejar de usar el metodo print vista en la v1
        //por lo que print queda eliminada y simplificamos.
        listNumbers.stream()
                .forEach(System.out::println);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> listNumbers){
        //LambdaExpression es una forma de crear un metodo, por lo que no necesitamos el metodo isEven
        //Lambda expression es una simplificada forma de un metodo
        listNumbers.stream()
                .filter(number -> number % 2 == 0) //Lambda expression
                .forEach(System.out::print);
    }

  //  private static void print(int number){
  //      System.out.println(number);
  //  }


  //  private static boolean isEven(int number){
  //      return number%2 == 0;
  //  }
}
