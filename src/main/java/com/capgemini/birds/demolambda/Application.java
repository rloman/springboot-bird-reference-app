package com.capgemini.birds.demolambda;

import org.hibernate.boot.jaxb.SourceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {


        List<Integer> numbers = Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89);


        // old farmer way
        /*
        List<Integer> evenNumbers = new ArrayList<>();

        for (int element : numbers) {
            if (element % 2 == 0) {
                evenNumbers.add(element);
                System.out.println(element);
            }
        }
        */


        // new lambda stream way using predicate

        System.out.println("Now I am using the very sexy lambda expressions for this ... ");
        numbers.stream().filter(n -> n % 2 == 0).filter(n -> n > 5).forEach(n -> {
            System.out.println(n);
        });


        // Below there are number, which are even, which are larger than 5 and they are squared
        System.out.println("Below there are number, which are even, which are larger than 5 and they are squared");
        numbers.stream().filter(n -> n % 2 == 0).filter(n -> n > 5).map(n -> n * n).forEach(n -> {
            System.out.println(n);
        });

        long numberSize = numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .peek(n -> {
                    System.err.println(n);
                })
                .filter(n -> n > 5).count();

        boolean isThereAFive = numbers
                .stream()
                .anyMatch(n -> n == 5);
        
    }
}
