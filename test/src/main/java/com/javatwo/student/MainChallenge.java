package com.javatwo.student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.javatwo.studentengagement.Course;

public class MainChallenge {
    public static void main(String[] args) {
         Course pmc = new Course("PMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGM", "Java Games Masterclass");


        // List<Student> students = Stream
        // .iterate(1, s -> s <=5000, s -> s +1)
        // .map(s -> Student.getRandomStudent(pmc,jmc))
        // .toList();


        List<Student> students = IntStream
        .rangeClosed(1, 5000)
        .mapToObj(s -> Student.getRandomStudent(pmc,jmc))
        .toList();

        double totalPercent = students.stream()
        .mapToDouble(s -> s.getPercentComplete("JMC"))
        .reduce(0, Double::sum);

        double avgPercentage = totalPercent / students.size();

        System.out.println("Average percentage, " + avgPercentage);

        int topPercent = (int) (1.25 * avgPercentage);

        System.out.println("Best percentage complete, " + topPercent);

        Comparator<Student> longTermStudent = Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardworkers = students.stream()
        .filter((s) -> s.getMonthsSinceActive("JMC") == 0)
        .filter((s) -> s.getPercentComplete("JMC") >= topPercent)
        .sorted(longTermStudent)
        .limit(10)
        .toList();

        hardworkers.forEach(s -> {
            s.addCourse(jgames);
            System.out.println(s);
        });
     
    }
}
