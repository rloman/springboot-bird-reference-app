package com.capgemini.birds.examstuff.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionTrainer {

    public static void main(String[] args) throws Exception {


        File f = new File("zoo.txt");


        String firstName = "Sanne";

        String[] firstNames = firstName.split("");

        System.out.println(firstNames[4]);


        try {
            FileReader fileReader = new FileReader(f);
        } catch (FileNotFoundException e) {
            System.out.println("That is not a valid file, you dombo ... ");
        }

        try {
            foo();
        } catch (Exception e) {

            // since I can fix it ... add a catch block here ...
            // and add some code here, never leave empty ...
            e.printStackTrace();

            throw e;
        }
    }

    public static void foo() throws Exception {
            bar();
    }

    public static void bar()  throws Exception {


        throw new Exception();


    }
}


