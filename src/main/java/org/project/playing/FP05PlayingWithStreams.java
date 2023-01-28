package org.project.playing;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP05PlayingWithStreams {
    public static void main(String[] args) {

        //Contar
        System.out.println(Stream.of(12,9,13,4,6,2,4,12,15).count());

        //Contar y acumular a partir de 0
        System.out.println(Stream.of(12,9,13,4,6,2,4,12,15).reduce(0,Integer::sum));

        //Con numeros primitivos es mucho mas eficiente
        /*
        Existen formas de poder usar Streams para numeros primitivos como son:
            - InStream
            - LongStream
            - DoubleStream
         */

        int[] numberArray = {12,9,13,4,6,2,4,12,15};

        System.out.println(Arrays.stream(numberArray).sum());
        System.out.println(Arrays.stream(numberArray).count());
        System.out.println(Arrays.stream(numberArray).average());
        System.out.println(Arrays.stream(numberArray).max());
        System.out.println(Arrays.stream(numberArray).min());

        IntStream.range(1,10).sum(); //Creamos rangos de 1 a 9 , 10 no incluye
        IntStream.rangeClosed(1,10).sum(); //Creamos rangos de 1 a 10, incluye el 10

        System.out.println("Algoritmos de generacion de numeros");

        System.out.println("Manera iterativa");
        System.out.println(IntStream.iterate(1,e -> e+2).limit(10).sum()); // Limite hasta el 10. Comienza desde 1

        System.out.println("Manera iterativa");
        System.out.println(IntStream.iterate(1,e -> e + 2).limit(10).peek(System.out::println).sum()); // peek -> hace algo con cada elemento

        //Boxed convierte el IntStream a Stream para asi dejarnos para a una lista
        System.out.println(IntStream.iterate(1,e -> e * 2).limit(10).boxed().collect(Collectors.toList()));


        //Reduce recibe un numero inicial y luego recibe un metodo cuyo resultado se acumulara
        System.out.println(LongStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply));

    }
}
