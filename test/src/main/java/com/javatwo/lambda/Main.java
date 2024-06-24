package com.javatwo.lambda;

public class Main extends Primate implements HasTail {

    public int age = 10;

    public boolean isTailStriped() {
        return false;
    }

    public static void main(String[] args) {
        Main lemur = new Main();
        System.out.println(lemur.age);


        HasTail hasTail = lemur;

       //? -> error -> can only access those references with hasTail hasTail.age;

        System.out.println(hasTail.isTailTripped());

        Primate primate = lemur;
           //? -> error -> can only access those references with hasTail primate.age;

        System.out.println(primate.hasHair());
    }

    @Override
    public boolean isTailTripped() {
        return false;
    }
}
