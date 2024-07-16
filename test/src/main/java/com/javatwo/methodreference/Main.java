package com.javatwo.methodreference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;


/**
 * InnerMain
 */
 class PlainOLd {

    private static int last_id = 1;

    private static int id;

    public PlainOLd(){ 
        id = PlainOLd.last_id++;
        System.out.println("Creating a plain old object :id = " + id);
    }
    
}

public class Main {
    public static void main(String[] args) {
           List<String> list = new ArrayList<>(List.of(
                "alpha", "bravo", "charlie", "delta"));

                list.forEach(System.out::println);

                calculator((a,b) -> a +b, 10, 20);
                calculator(Integer::sum, 10, 20);

                Supplier<PlainOLd> reference1 = () -> new PlainOLd();

                Supplier<PlainOLd> reference2 = PlainOLd::new;

                PlainOLd newPojo = reference2.get();

                calculator((a,b) -> a.concat(b), "Hello ", "World");

                calculator(String::concat, "Hello ", "World");
    }

    private static <T> void calculator(BinaryOperator<T> function, T v1, T v2){
        T result = function.apply(v1, v2);
        System.out.println("Result of operation: " + result);
    }
}
