package org.project.functionalmind;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FP06FunctionalMakesEasy {
    public static void main(String[] args) throws IOException {
        List<String> coursesList = List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azue","Docker","Kubernetes");
        List<String> coursesListModified = new ArrayList<>(coursesList);


        coursesListModified.replaceAll(String::toUpperCase);

        coursesListModified.removeIf(course -> course.length() > 6);


        Files.lines(Paths.get("src/main/java/org/project/functionalmind/text"))
                .map(str -> str.split(""))
                .flatMap(Arrays::stream)
                .forEach(System.out::println);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<10000; i++){
                    System.out.println(Thread.currentThread().getId() + ":" + i);
                }
            }
        };

        //Version funcional
        Runnable runnableFunctional = () -> {
            for (int i = 0; i<10000; i++){
                System.out.println(Thread.currentThread().getId() + ":" + i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable);
        thread2.start();

        Thread thread3 = new Thread(runnable);
        thread3.start();


    }
}
