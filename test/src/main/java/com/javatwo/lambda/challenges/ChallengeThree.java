package com.javatwo.lambda.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChallengeThree {
    public static void main(String[] args) {

         List<String> list = new ArrayList<>(List.of(
                "brian", "Ian", "kev", "Vin", "nico", "bob", "anna"));
        
       // list.replaceAll(a -> a.toUpperCase() + a.charAt(a.length()/2) + ".");
    //    to upper case
    System.out.println("Uppercase_________");
       list.replaceAll(a -> a.toUpperCase());
       list.forEach(a -> System.out.println(a));

    System.out.println("Adding character___________");
    list.replaceAll(a -> a.charAt(a.length()/2) + ".");
    list.forEach(a -> System.out.println(a));

    System.out.println("Printing last name");
    



    }
}
