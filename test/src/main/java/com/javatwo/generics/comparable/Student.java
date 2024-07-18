package com.javatwo.generics.comparable;

public class Student implements Comparable {

    String name;

    

    public Student(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "Student [name=" + name + "]";
    }



    @Override
    public int compareTo(Object o) {
        Student other = (Student) o;
        return name.compareTo(other.name);
    }
    
}
