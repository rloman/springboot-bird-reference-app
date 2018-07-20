package com.capgemini.birds.examstuff;


import com.capgemini.birds.model.Bird;
import org.apache.tomcat.jni.SSL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyOwnBeans {

    @Bean
    public Bird eva() {
        Bird result = new Bird();
        result.setName("Eva");

        return result;
    }

    @Bean
    public Bird rachid() {
        Bird result = new Bird();
        result.setName("Rachid");

        return result;
    }

    @Bean
    public Bird hielke() {
        Bird result = new Bird();
        result.setName("Hielke");

        result.setAge(28);

        return result;
    }

    @Bean
    public Bird stephan() {
        Bird result = new Bird();
        result.setName("Stephan");

        return result;
    }

    /*
    @Bean
    public SSL ssl1() {

        SSL result = new SSL();
        result.setBIO(3,4,5);

        return result;
    }
    */

    @Bean
    public String companyName() {
        return "Capgemini";
    }



}
