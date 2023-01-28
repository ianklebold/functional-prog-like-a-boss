package org.project.playingfurther;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewCourse;
    private int noOfCourse;

    public Course(String name, String category, int reviewCourse, int noOfCourse) {
        super();
        this.name = name;
        this.category = category;
        this.reviewCourse = reviewCourse;
        this.noOfCourse = noOfCourse;
    }

    public Course() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewCourse() {
        return reviewCourse;
    }

    public void setReviewCourse(int reviewCourse) {
        this.reviewCourse = reviewCourse;
    }

    public int getNoOfCourse() {
        return noOfCourse;
    }

    public void setNoOfCourse(int noOfCourse) {
        this.noOfCourse = noOfCourse;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", reviewCourse=" + reviewCourse +
                ", noOfCourse=" + noOfCourse +
                '}';
    }
}

public class FP05PlayingFurtherWithStreams {
    public static void main(String[] args) {
        List<String> coursesList = List.of("Spring","Spring boot","API","Microservices","AWS","PCF","Azue","Docker","Kubernetes");

        //Joining es un metodo que permite agrupar las cadenas de caracteres y juntarlas mediante algun separador.
        System.out.println(coursesList.stream().collect(Collectors.joining(" ")));


        //El metodo split devuelve un array con cada elemento separado por algo
        //Entonces en el siguiente caso se nos crea una lista de arrays
        //Si yo quiero una lista de los resultados de los arrays debemos aplanarlo
        coursesList.stream().map(course -> course.split("")).collect(Collectors.toList());

        //Flatmap lo que hace es reemplazar las listas o arrays del stream por su contenido
        System.out.println("Aplanando con flatmap");
        System.out.println(
                coursesList.stream().map(course -> course.split(""))
                        .flatMap(Arrays::stream)
                        .collect(Collectors.toList())
        );

        System.out.println("Aplanando con flatmap con distinct");
        System.out.println(
                coursesList.stream().map(course -> course.split(""))
                        .flatMap(Arrays::stream)
                        .distinct()
                        .collect(Collectors.toList())
        );


        //Higher order function es una funcion que devuelve otra funcion
        Predicate<Course> reviewScoreGreaterThan95Predicate2 = createPredicateWithCutOffReviewScore(95);

        Predicate<Course> reviewScoreGreaterThan90Predicate2 = createPredicateWithCutOffReviewScore(90);


        coursesList.stream().filter(courses -> courses.length() > 11).map(String::toUpperCase).findFirst();
    }

    //Este de aqui seria el higherOrder function
    private static Predicate<Course> createPredicateWithCutOffReviewScore(int cutoffReviewScore){
        return course -> course.getReviewCourse() > cutoffReviewScore;
    }
}
