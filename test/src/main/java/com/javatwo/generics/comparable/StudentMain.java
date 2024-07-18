package com.javatwo.generics.comparable;

import java.util.Arrays;

public class StudentMain {
    public static void main(String[] args) {
        Student tim = new Student("Tim");

        Student[] students = {
            new Student("Brian"),
            new Student("Ann"),
            new Student("Ian"),
            new Student("Kev"),
        };

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }
}
