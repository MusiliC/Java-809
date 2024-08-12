package com.javatwo.student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Collectors.*;

import com.javatwo.studentengagement.Course;

public class MainMapping {
    public static void main(String[] args) {
        Course pmc = new Course("PMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        Course jgames = new Course("JGM", "Java Games Masterclass");

        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(pmc, jmc))
                .toList();

        var mappedStudents = students.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode));

        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("--------------------------");

        int minAge = 25;

        var youngerSet = students.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode,
                        Collectors.filtering(s -> s.getAge() <= minAge, Collectors.toList())));

        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("--------------------------");

        var experienced = students.stream()
                .collect(Collectors.partitioningBy(Student::hasProgrammingExperience));

        System.out.println("Experienced students " + experienced.get(true).size());

        System.out.println("--------------------------");

        var experiencedCount = students.stream()
                .collect(Collectors.partitioningBy(Student::hasProgrammingExperience, Collectors.counting()));

        System.out.println("Experienced students with count " + experiencedCount.get(true));

        System.out.println("--------------------------");

        var experiencedAndActive = students.stream()
                .collect(Collectors.partitioningBy(
                        s -> s.hasProgrammingExperience() && s.getMonthsSinceActive() == 0,
                        Collectors.counting()));

        System.out.println("Experienced students with count and active " + experiencedAndActive.get(true));

        System.out.println("--------------------------");

        var multiLevel = students.stream()
                .collect(Collectors.groupingBy(Student::getCountryCode, Collectors.groupingBy(Student::getGender)));
        System.out.println("Multilevel Stream");

        multiLevel.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k1, v1) -> {
                System.out.println(k1 + " " + v1.size());
            });
        });

        // ! FLatMap Code

        System.out.println("!!!!FlatMap Code!!!!");

        long studentBodyCount = 0;

        for (var list : experienced.values()) {
            studentBodyCount += list.size();
        }

        System.out.println("Student body count = " + studentBodyCount);

        studentBodyCount = experienced.values().stream()
                .mapToInt(l -> l.size())
                .sum();

        System.out.println("Student body count = " + studentBodyCount);

        System.out.println("-----------------------------------");

        studentBodyCount = experienced.values().stream()
                .map(l -> l.stream()
                        .filter(s -> s.getMonthsSinceActive() <= 3)
                        .count())
                .mapToLong(l -> l)
                .sum();

        System.out.println("Student body count = " + studentBodyCount);


        System.out.println("!!!!FlatMap Code!!!!");
        System.out.println("-----------------------------------");
        

        long count = experienced.values().stream()
        .flatMap(l -> l.stream())
        .filter(s -> s.getMonthsSinceActive() <=3)
        .count();

        System.out.println("Active students " + count);
    }
}
