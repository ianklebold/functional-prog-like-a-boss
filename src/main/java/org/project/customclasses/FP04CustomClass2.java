package org.project.customclasses;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.project.customclasses.FP04CustomClass.createCourses;

public class FP04CustomClass2 {
    public static void main(String[] args) {
        List<Course> courses = createCourses();

        //SUM - Suma el numero o cantidad de algo. - Puede devolver 0
        System.out.println("Cantidad de personas en el curso ");
        System.out.println(courses.stream()
                .filter(course -> course.getReviewCourse() > 95)
                .mapToInt(Course::getNoOfCourse)//Si el atributo a sumar es un Primitivo es preferible usar mapToInt y no el map de literal
                .sum()
        );

        //AVERAGE - Obtiene el promedio de algo. - Devuelve un OptionalDouble
        System.out.println("Promedio de las visitas en el curso ");
        System.out.println(courses.stream()
                .filter(course -> course.getReviewCourse() > 95)
                .mapToInt(Course::getReviewCourse)//Si el atributo a sumar es un Primitivo es preferible usar mapToInt y no el map de literal
                .average()
        );

        //COUNT
        System.out.println("Contabiliza algo ");
        System.out.println(courses.stream()
                .filter(course -> course.getReviewCourse() > 95)
                .mapToInt(Course::getReviewCourse)//Si el atributo a sumar es un Primitivo es preferible usar mapToInt y no el map de literal
                .count()
        );

        //Grouping courses into Map using groupingBy
        //Lo que hace es agrupar en un map en listas separadas por comas aquellos elementos que cumplen con un criterio de agrupacion
        //Las keys de cada lista son los titulos o valores por los que estas agrupando.
        System.out.println("Group by category ");
        System.out.println(
        courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory))
        );

        //Grouping courses into Map using groupingBy
        //Lo que hacemos es agrupar y de esos obtenemos la cantidad agrupada. En este caso solo devuelve una lista
        System.out.println("Group by category y retornar la cantidad de cursos por categoria ");
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
        );

        System.out.println("Group by category y ordena por review course ");
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.maxBy(Comparator.comparing(Course::getReviewCourse))))
        );

        //Grouping courses into Map using groupingBy
        //Agrupa los cursos y mapea uno de sus atributos en una coleccion. Devuelve un MAP de listas con el atributo
        System.out.println("Group by category y retorna el nombre de los cursos en una lista ");
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(Course::getCategory,
                                Collectors.mapping(Course::getName,Collectors.toList()))));




    }

}
