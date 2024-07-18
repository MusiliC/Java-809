package com.javatwo.generics.comparable;

public class Main {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0,5,10,-50, 50};

        String banana = "banana";
        String[] fruits = {"banana", "pear", "apple", "BANANA"};

        for (Integer i : others) {
            int val = five.compareTo(i);
            System.out.printf(
                "Compare %d to %d: %s (%d)\n", 
                five, i, (val == 0 ? "==" : val < 0 ? "<" : ">"), val
            );

        }

        for (String s : fruits) {
            int val = banana.compareTo(s);

            System.out.printf(
                "Compare %s to %s: %s (%s)\n", 
                banana, s, (val == 0 ? "==" : val < 0 ? "<" : ">"), val
            );
        }
    
    }
}
