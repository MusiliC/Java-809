package com.javatwo.student;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.javatwo.studentengagement.Course;

public class MainOptional {
    public static void main(String[] args) {
        Course pmc = new Course("PMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(pmc, jmc))
                .limit(1000)
                .collect(Collectors.toList());

        Optional<Student> o1 = getStudent(null, "first");
        System.out.println("Empty = " + o1.isEmpty() + ", Present = " + o1.isPresent());

        System.out.println(o1);
        o1.ifPresentOrElse(System.out::println, () -> System.out.println("Empty value"));

        Optional<Student> o2 = getStudent(students, "first");
        System.out.println("Empty = " + o2.isEmpty() + ", Present = " + o1.isPresent());

        System.out.println(o2);
        if (o2.isPresent())
            System.out.println(o2.get());

        // Student firstStudent = o2.orElse(getDummyStudent(jmc));
        // ? The above method impacts performance

        Student firstStudent = o2.orElseGet(() -> getDummyStudent(pmc));

        long id = firstStudent.getStudentId();

        System.out.println("First student id is " + id);

        // ? Optional And Stream

        List<String> countries = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .toList();

        Optional.of(countries)
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("FR"))
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Missing FR"));

    }

    private static Optional<Student> getStudent(List<Student> list, String type) {
        if (list == null || list.size() == 0) {
            return Optional.empty();
        } else if (type.equals("first")) {
            return Optional.ofNullable(list.get(0));
        } else if (type.equals("last")) {
            return Optional.ofNullable(list.get(list.size() - 1));
        }

        return Optional.ofNullable(list.get(new Random().nextInt(list.size())));
    }

    private static Student getDummyStudent(Course... courses) {
        System.out.println("Get the dummy student");
        return new Student("No", 1, 1, "U", false, courses);
    }
}
