package com.javatwo.student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.javatwo.studentengagement.Course;

public class MainTerminalOptional {
    public static void main(String[] args) {
        Course pmc = new Course("PMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pmc, jmc))
                .limit(1000)
                .toList();

        int minAge = 21;

        students.stream()
                .filter((s -> s.getAge() < minAge))
                .sorted(Comparator.comparing(Student::getAge))
                .findAny()
                .ifPresentOrElse(s -> System.out.println(s.getAge()), () -> System.out.println("No value"));

        students.stream()
                .filter((s -> s.getAge() < minAge))
                .mapToInt(Student::getAge)
                .average()
                .ifPresentOrElse(s -> System.out.println(s), () -> System.out.println("No Average"));

        students.stream()
                .filter((s -> s.getAge() < minAge))
                .map(Student::getCountryCode)
                .distinct()
                .reduce((a, b) -> String.join(",", a, b))
                .ifPresentOrElse(System.out::println, () -> System.out.println("None found"));

        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("FR"))
                .findAny()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Missing FR"));
    }
}
