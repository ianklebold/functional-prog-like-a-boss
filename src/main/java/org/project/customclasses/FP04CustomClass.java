package org.project.customclasses;

import java.util.Comparator;
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

public class FP04CustomClass {
    public static void main(String[] args) {
        List<Course> courses = createCourses();

        //allMatch, noneMatch and anyMatch
        Predicate<Course> courseALLMATCHPredicate = course -> course.getReviewCourse() > 90;
        Predicate<Course> courseNONEMATCHPredicate = course -> course.getReviewCourse() == 100;
        Predicate<Course> courseANYMATCHPredicate = course -> course.getReviewCourse() > 95;


        // ALL MATCH todos matchean con algo
        courses.stream().allMatch(courseALLMATCHPredicate);

        // NONE MATCH ninguno matchean con algo
        courses.stream().noneMatch(courseNONEMATCHPredicate);

        // ANY MATCH alguno matchea con algo
        courses.stream().anyMatch(courseANYMATCHPredicate);

        //Obntenemos una lista ordenada por numero de estudiantes. Por default de es de manera creciente
        Comparator<Course> comparingByNumberOfStudents
                = Comparator.comparing(Course::getNoOfCourse);

        //Obntenemos una lista ordenada por numero de estudiantes.Con reversed convertimos de creciente a decreciente
        Comparator<Course> comparingByNumberOfStudentsDecreacing
                = Comparator.comparing(Course::getNoOfCourse).reversed();


        System.out.println("Lista ordenada decreciente, por numero de estudiantes: ");
        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudents)
                .collect(Collectors.toList()));


        System.out.println("Lista ordenada creciente, por numero de estudiantes:: ");
        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsDecreacing)
                .collect(Collectors.toList()));

        //Obntenemos una lista ordenada por numero de estudiantes y reviews
        Comparator<Course> comparingByNumberOfStudentsAndReviews
                = Comparator.comparing(Course::getNoOfCourse)
                .thenComparing(Course::getReviewCourse)
                .reversed();

        System.out.println("Lista ordenada creciente, por numero de estudiantes y reviews: ");
        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviews)
                .collect(Collectors.toList()));


        //SKIP - Lo usamos para saltearnos los N primeros elementos que nos retorne la lista

        System.out.println("Lista ordenada creciente, por numero de estudiantes y reviews: ");
        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviews)
                        .skip(3)
                .collect(Collectors.toList()));

        //LIMIT - Lo usamos para indicar un tope maximo o limite de elementos a ordenar y mostrar

        System.out.println("Lista ordenada creciente, por numero de estudiantes y reviews: ");
        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviews)
                        .limit(5)
                .collect(Collectors.toList()));

        //SKIP AND LIMIT - Podemos combinar las operaciones, SKIP es saltear los N elementos y luego limita a mostrar N proximos
        System.out.println("Lista ordenada creciente, por numero de estudiantes y reviews: ");
        System.out.println(courses.stream()
                .sorted(comparingByNumberOfStudentsAndReviews)
                .skip(3)
                .limit(5)
                .collect(Collectors.toList()));

        //TAKE WHILE - Obtenemos todos los elementos mientras que se cumple una condicion. Si no se rompe el while y no sigue
        System.out.println("Obtener lista mientras su review sea mayor o igual a 95: ");
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewCourse()>=95)
                .collect(Collectors.toList()));


        //DROP WHILE - No retorna a aquellos elementos que cumplan con la condicion
        System.out.println("Saltear a aquellos cuya review sea mayor o igual a 95: ");
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewCourse()>=95)
                .collect(Collectors.toList()));

        //MAX - Obtiene un maximo bajo un criterio (Comparator) devuelve un optional
        //Logicamente este sera el ultimo en la lista ordenada de forma ascendente
        System.out.println("Obtener el valor maximo de los elementos ordenados de forma ascendiente por numero de estudiantes y reviews: ");
        System.out.println(courses.stream()
                .max(comparingByNumberOfStudentsAndReviews)
        );

        //MIN - Obtiene un minimo bajo un criterio (Comparator) devuelve un optional
        //Logicamente este sera el primer en la lista ordenada de forma ascendente
        System.out.println("Obtener el valor minimo de los elementos ordenados de forma ascendiente por numero de estudiantes y reviews: ");
        System.out.println(courses.stream()
                .min(comparingByNumberOfStudentsAndReviews)
        );

        //ORELSE
        //El optional puede devolver un EMPTY en este caso podemos usar un OrElse que devuelve un valor en caso de que devuelve EMPTY
        System.out.println("Devolveme un objeto nuevo si no encontras nada: ");
        System.out.println(courses.stream()
                .min(comparingByNumberOfStudentsAndReviews)
                .filter(course -> course.getReviewCourse() == 100) //Forzamos que no llegue nada
                .orElse(new Course("Curso de orElse","No hay nada",91,20000))
        );

        //FIND FIRST - Obtiene el primer elemento de la lista - Devuelve un optional
        System.out.println("Devolveme el primer objeto de la lista ");
        System.out.println(courses.stream()
                .filter(course -> course.getReviewCourse() > 95)
                .findFirst()
        );

        //FIND ANY - Es libre de elegir (No deterministico) cualquier elemento del stream que cumpla con el criterio
        System.out.println("Devolveme el primer objeto de la lista ");
        System.out.println(courses.stream()
                .filter(course -> course.getReviewCourse() > 95)
                .findAny()
        );
    }

    protected static List<Course> createCourses(){
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        return courses;
    }
}
