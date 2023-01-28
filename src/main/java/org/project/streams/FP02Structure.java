package org.project.streams;


import java.util.List;

public class FP02Structure {
    public static void main(String[] args) {

        List<Integer> listInteger = List.of(1,2,14,13,12,11,16,9,91,13,2,1,21);


    }

    private static Integer addListStructured(List<Integer> listNumbers) {
        int sum = 0;
        for (int number:listNumbers){
            sum += number;
        }
        return sum;
    }

}
