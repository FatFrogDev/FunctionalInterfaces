package org.globant.firstexercise;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Person> personList = new FirstExercise().getPersonList();
       personList.forEach(System.out::println);


    }
}