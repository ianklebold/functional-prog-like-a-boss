package org.project.interfaces;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FP03FunctionalConsumerExample {
    public static void main(String[] args) {
        //Consumer<String> consumer1 = () -> {}; //Esto no compila

        Consumer<String> consumer1 = (str) -> {}; //Esto compila

        Consumer<String> consumer2 = (str) ->  System.out.println(str);//Esto compila

        BiConsumer<String,String> consumer3 = (str,str2) ->  System.out.println(str); //Esto compila, ignora el 2 parametro

        Supplier<String> supplier = () -> "String"; //Esto compila


        //Supplier<String> supplier2 = () -> {"String"}; //Esto no compila falta ; despues de String


        //Supplier<String> supplier3 = () -> {"String";}; //Esto no compila, falta return

        Supplier<String> supplier2 = () -> {return "String";}; //Esto compila




    }
}
