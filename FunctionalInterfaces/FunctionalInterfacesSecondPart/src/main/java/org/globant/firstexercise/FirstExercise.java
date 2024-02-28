package org.globant.firstexercise;

import java.util.*;
import java.util.function.*;

import com.github.javafaker.Faker;

public class FirstExercise {

    private List<Person> personList = personGenerator(5);

    /**
     * Generates a list of persons with fake data using a supplier.
     *
     * @param size the size of the list of persons to be generated
     * @return List  of random generated persons.
     */
    private List<Person> personGenerator(int size) {
        if (size <= 0) {
            System.out.println("The size must be greater than 0");
            return null;
        }
        List<Person> personList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            personList.add(fakePersonSupplier.get());
        }
        return personList;
    }

    ;

    /**
     * Supplier of a person with fake data of a person "living abroad", according to the exercise requirements.
     */
    private final static Supplier<Person> fakeAbroadPersonSupplier = () -> {
        Faker faker = new Faker();
        Person newp = new Person(faker.name().firstName(), "CC-13" + String.valueOf((int) (Math.random() * 9) + 1) // <- Fake document "randomly" generated
                + "8213" + String.valueOf((int) (Math.random() * 9) + 1),
                "Calle " + faker.address().fullAddress(), (int) (Math.random() * 50) + 1);
        return newp;
    };


    /**
     * Supplier of a person with fake data of a person according to the exercise requirements.
     *
     * @returns Person with fake data.
     */
    private final static Supplier<Person> fakePersonSupplier = () -> {
        Faker faker = new Faker();
        Person newp = new Person(faker.name().fullName(), "CC-13" + String.valueOf((int) (Math.random() * 9) + 1) // <- Fake document "randomly" generated
                + "8213" + String.valueOf((int) (Math.random() * 9) + 1),
                "Calle 13#82-3", (int) (Math.random() * 50) + 1);
        return newp;
    };


    public List<Person> getPersonList() {
        return personList;
    }


    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    ;
}
