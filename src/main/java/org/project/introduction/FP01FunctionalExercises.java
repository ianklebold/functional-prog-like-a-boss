package org.project.introduction;

import java.util.List;

public class FP01FunctionalExercises {
    public static void main(String[] args) {

        List<Integer> numbersList = List.of(1,2,14,15,12,32,12,11,10,9,6,3,1,35,7);
        List<String> coursesList = List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azue","Docker","Kubernetes");

        printOnlyOddNumbersFromList(numbersList);
        printAllCoursesIndividually(coursesList);
        printOnlySpringCourses(coursesList);
        printCoursesWith4LettersAtleast(coursesList);
        printSquaresOfNumbers(numbersList);
        printCubesOfOddNumbers(numbersList);
        printNumberOfCharactersInEachCourseName(coursesList);
    }



    private static void printOnlyOddNumbersFromList(List<Integer> numbersList) {
        numbersList.stream()
                .filter(number -> number % 2 != 0 )
                .forEach(System.out::println);
        System.out.println(" ");

    }

    private static void printAllCoursesIndividually(List<String> coursesList){
        coursesList.stream().forEach(System.out::print);
        System.out.println(" ");

    }

    private static void printOnlySpringCourses(List<String> coursesList) {
        coursesList.stream()
                .filter(course -> course.toLowerCase().contains("spring"))
                .forEach(System.out::print);
        System.out.println(" ");

    }

    private static void printCoursesWith4LettersAtleast(List<String> coursesList){
        coursesList.stream()
                .filter(course -> course.length()>=4)
                .forEach(System.out::print);
        System.out.println(" ");
    }

    private static void printSquaresOfNumbers(List<Integer> numbersList){
        numbersList.stream()
                .map(number -> number * number)
                .forEach(System.out::println);
        System.out.println(" ");
    }

    private static void printCubesOfOddNumbers(List<Integer> numbersList){
        numbersList.stream()
                .filter(number -> number % 2 != 0 )
                .map(number -> number * number * number)
                .forEach(System.out::println);
        System.out.println(" ");
    }

    private static void printNumberOfCharactersInEachCourseName(List<String> coursesList){
        coursesList.stream()
                .map(String::length)
                .forEach(System.out::println);
        System.out.println(" ");
    }

}
