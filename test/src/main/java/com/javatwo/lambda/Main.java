package com.javatwo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("________________For each___________");

        //? Consumer - Takes single argument and does not return anything

        list.forEach((s) -> System.out.println(s));

        int result = calculator((x,y) -> x+y, 10, 20);
        var result2 = calculator((x,y) -> x/y, 10.0, 2.0);

        // ? Predicate - Takes in inputs and returns boolean

        list.removeIf(x -> x.equalsIgnoreCase("alpha"));
        System.out.println("Predicate..........");
        list.forEach(s -> System.out.println(s));

        list.addAll(List.of("Brian", "Paul"));

        System.out.println("_____________functional interface");

        // ? Functional interface - takes an argument and returns a result

        list.replaceAll(s -> s.charAt(0) + "-" + s.toUpperCase());
        list.forEach(s-> System.out.println(s));

         // ? Supplier interface - does not take any argument

         String[] names = {"Carol", "Bob", "Raph", "Kasee"};

         String[] randomList = randomSelectedValues(15, names, () -> new Random().nextInt(0, names.length));
         System.out.println(Arrays.toString(randomList));
    }

    public static <T> T calculator(Operation<T> funOperation,T value1,T value2){
        T result = funOperation.operate(value1, value2);
        System.out.println("Result of operation " + result);
        return result;
    }

    public static String[] randomSelectedValues (int count, String[] values, Supplier<Integer> s){
        String [] selectedValues = new String[count];

        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
            
        }

        return selectedValues;
    }
}
