package org.project.streams;


import java.util.List;

public class FP02FunctionalExercises {
    public static void main(String[] args) {

        List<Integer> listInteger = List.of(1,2,14,13,12,11,16,9,91,13,2,1,21);

        sumTheSquareNumberOfTheList(listInteger);
        sumTheCubeNumberOfTheList(listInteger);

        sumTheSquareNumberOfTheListV2(listInteger);
        sumTheCubeNumberOfTheListV2(listInteger);


        System.out.println(sumTheOddNumbersOfTheList(listInteger));
    }

    private static Integer sumTheOddNumbersOfTheList(List<Integer> listInteger){

        System.out.println("Sum the odd numbers");
        return listInteger.stream()
                 .reduce(0, (x,y) -> y % 2 != 0? x+y:x );
    }

    private static Integer sumTheSquareNumberOfTheList(List<Integer> listInteger){
        return listInteger.stream()
                .map(value -> value*value)
                .reduce(0,Integer::sum);
    }

    private static Integer sumTheSquareNumberOfTheListV2(List<Integer> listInteger){
        return listInteger.stream()
                .reduce(0,(x,y) -> x*x + y*y);
    }

    private static Integer sumTheCubeNumberOfTheList(List<Integer> listInteger){
        return listInteger.stream()
                .map(value -> value*value*value)
                .reduce(0,Integer::sum);
    }

    private static Integer sumTheCubeNumberOfTheListV2(List<Integer> listInteger){
        return listInteger.stream()
                .reduce(0,(x,y) -> x*x*x + y*y*y);
    }


}
