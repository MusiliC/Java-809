package com.javatwo.streams;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        
        List<String> bingPool = new ArrayList<>(75);

        int start = 1;

        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < (start + 15); i++) {
                bingPool.add("" + c + i);
               // System.out.println("" + c + i);
            }
            start += 15;
        }

        Collections.shuffle(bingPool);
        for (int i = 0 ; i < 15; i++) {
            System.out.println(bingPool.get(i));
        }

        System.out.println("------------------------------------");

        bingPool.stream()
        .limit(15)
        .filter(s -> s.indexOf("G") == 0 || s.indexOf("O") == 0)
        .map(s -> s.charAt(0) + "-" + s.substring(1))
        .sorted()
        .forEach(s -> System.out.println(s + " "));

        // ? Stream sources
        System.out.println("Stream sources");
        String[] fruits = {"mango", "orange", "ovacado"};

      var firstStream =   Arrays.stream(fruits)
        .map(t -> t.toUpperCase());
       // .forEach(System.out::println);

       var secondStream =  Stream.of("one", "two", "three")
        .sorted(Comparator.naturalOrder());
       // .forEach(System.out::println);

        Stream.concat(firstStream, secondStream)
        .forEach(System.out::println);


    }
}
