package com.javatwo.lambda.challenges;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;

public class ChallengeOne {

    public static void main(String[] args) {
        Consumer<String> printWords = new Consumer<String>() {
            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split("");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        

    }

    // lambda of the above method
    static Consumer<String> printWordsLambda = sentence -> {
      
        Arrays.asList(sentence.split(" ")).forEach(p -> System.out.println(p));
    };
   
}
