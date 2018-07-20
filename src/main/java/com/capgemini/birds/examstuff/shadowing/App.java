package com.capgemini.birds.examstuff.shadowing;

public class App {

    public static void main(String[] args) {
        Person w = new Child();

        System.out.println(w.firstName);

        Child w1 = new Child();

        w1.foo();

        System.out.println(w.getClass());

        System.out.println(w.getClass().getSimpleName());
    }
}
