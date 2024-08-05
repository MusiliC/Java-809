package com.javatwo.student;

import java.util.stream.Stream;

import com.javatwo.studentengagement.Course;

public class Main {
    public static void main(String[] args) {
        Course pmc = new Course("PMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
       

        Stream.generate(() -> Student.getRandomStudent(pmc, jmc))
        .limit(10)
        .forEach(System.out::println);
    }
}
