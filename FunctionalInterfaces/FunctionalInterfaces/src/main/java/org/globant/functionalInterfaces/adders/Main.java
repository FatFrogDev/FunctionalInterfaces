package org.globant.functionalInterfaces.adders;

import java.util.function.BiFunction;

/**
 * Main class to implement some functional interfaces through sum some variable types, such as Integer, Double and Boolean.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Integer adder");
        Integer integerSum = integerAdder.apply(14, 2);
        System.out.println(integerSum);

        System.out.println("Boolean adder");
        Boolean booleanSum = booleanAdder.apply(false, false);
        System.out.println(booleanSum);

        System.out.println("Double adder");
        Double doubleSum = doubleAdder.apply(13.3D, 120.2D);
        System.out.println(doubleSum);
    }

    /**
     * IntegerAdder
     * Use a functional interface to sum two numbers
     *
     * @params Integer t, Integer u.
     * @returns Integer sum of the two given numbers.
     */
    final static BiFunction<Integer, Integer, Integer> integerAdder = Integer::sum;

    /**
     * Boolean adder.
     * Compares if two boolean conditions, returns its "sum".
     *
     * @params Boolean t, Boolean u.
     * @returns Boolean result of the given booleans.
     */
    final static BiFunction<Boolean, Boolean, Boolean> booleanAdder = Boolean::logicalAnd;


    /**
     * The Double adder.
     * Sum two doubles given.
     *
     * @params Double t, Double u.
     * @returns Double result of the sum of given doubles.
     */
    final static BiFunction<Double, Double, Double> doubleAdder = Double::sum;

}