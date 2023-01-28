package org.project.playingfurther;

import java.util.stream.LongStream;

public class FP05Parallelizing {
    public static void main(String[] args) {

        /**
         * Los streams nos permiten paralelizar. En una programacion estructurada esto no es posible
         * ya que en la progrmacion estructurada existen estados (variables) que cambian constantemente
         * de valor, por lo que paralelizar eso es imposible ya que estas variables cambian constantemente.
         *
         * Al paralelizar lo que estamos haciendo es, hacer ejecutar las operaciones del stream en multiples
         * partes y una vez termindas juntar todas estas partes para obtener el resultado
         */
        long time = System.currentTimeMillis();

        //0,10000000
        System.out.println(
                LongStream.range(0,10000000).parallel().sum()
        );


        System.out.println(System.currentTimeMillis() - time + " Milisegundos");

    }
}
