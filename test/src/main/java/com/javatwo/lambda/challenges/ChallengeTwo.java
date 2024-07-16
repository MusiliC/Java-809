package com.javatwo.lambda.challenges;

import java.util.function.Function;
import java.util.function.Supplier;

public class ChallengeTwo {
    public static void main(String[] args) {
        System.out.println(everySecondCharacter((t) -> t, "1234567890"));

        System.out.println(challenge.get());
    }

   

    static String everySecondCharacter(Function<String, String> secCharacter, String t) {
        return secCharacter.apply(t);
    }

   static Supplier<String> challenge = () -> {

        return "I love java";
    };
}
