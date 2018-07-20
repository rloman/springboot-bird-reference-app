package com.capgemini.birds.examstuff.component;


import com.capgemini.birds.model.Bird;
import org.apache.tomcat.jni.SSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyOwnComponent {

    @Autowired
    private Bird eva;

    @Autowired
    private Bird rachid;

    @Autowired
    private Bird hielke;

    public int add(int a, int b) {
        return a+b;
    }

}
