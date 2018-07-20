package com.capgemini.birds.examstuff.shadowing;

public class Child extends Person {

    public String firstName = "Willempie";

    public void foo() {
        System.out.println(super.firstName);
    }
}
