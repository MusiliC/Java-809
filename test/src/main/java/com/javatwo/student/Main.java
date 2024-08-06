package com.javatwo.student;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.javatwo.studentengagement.Course;

public class Main {
    public static void main(String[] args) {
        Course pmc = new Course("PMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        // Stream.generate(() -> Student.getRandomStudent(pmc, jmc))
        // .limit(10)
        // .forEach(System.out::println);

        Student[] students = new Student[1000];

        Arrays.setAll(students, (i) -> Student.getRandomStudent(pmc, jmc));


        for (String gender : List.of("M", "F", "U")) {
            var myStudents = Arrays.stream(students)
                    .filter((s) -> s.getGender().equals(gender));
            System.out.println("# of " + gender + " students " + myStudents.count());
        }

        List<Predicate<Student>> list = List.of(
            (s) -> s.getAge() < 30,
            (Student s) -> s.getAge() > 30 && s.getAge() < 60
        );

        long total = 0;

        for (int i = 0; i < list.size(); i++) {
            var myStudents = Arrays.stream(students)
            .filter(list.get(i));
            long cnt = myStudents.count();
            total += cnt;

            
        }
    }
}
