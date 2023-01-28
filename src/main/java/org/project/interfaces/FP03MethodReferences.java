package org.project.interfaces;

import java.util.List;

public class FP03MethodReferences {

    private static void print(String str){
        System.out.println(str);
    }

    public static void main(String[] args) {
        List<String> coursesList = List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azue","Docker","Kubernetes");

        coursesList.stream()
                .map(String::toUpperCase)
                .forEach(FP03MethodReferences::print);

    }
}
