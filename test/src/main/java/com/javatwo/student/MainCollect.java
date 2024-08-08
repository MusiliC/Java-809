package com.javatwo.student;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.javatwo.studentengagement.Course;

public class MainCollect {
    public static void main(String[] args) {
        Course pmc = new Course("PMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = 
        Stream.generate(() -> Student.getRandomStudent(pmc, jmc))
        .limit(1000)
        .toList();

        Set<Student> australianStudents = students.stream()
        .filter((s) -> s.getCountryCode().equalsIgnoreCase("AU"))
        .collect(Collectors.toSet());

        System.out.println("Australian students " + australianStudents.size());


        System.out.println();

        Set<Student> underThirty = students.stream()
        .filter((s) -> s.getAgeEnrolled() <30)
        .collect(Collectors.toSet());

        System.out.println("Under thirty students " + underThirty.size());


        Set<Student> youngAussies = new TreeSet<>(Comparator.comparing(Student::getAge));

        youngAussies.addAll(australianStudents);
        youngAussies.retainAll(underThirty);

        youngAussies.forEach((s) -> System.out.println(s.getAge() + " "));

        System.out.println();

        String countryList = students.stream()
        .map(Student::getCountryCode)
        .distinct()
        .sorted()
        .reduce("", (r,v) -> r + " " + v);

        System.out.println("Country list = " + countryList);

    }
}
