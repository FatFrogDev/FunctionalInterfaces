package org.globant.functionalInterfaces.FIImplementation;

import java.util.Random;
import java.util.function.*;

/**
 * Implements all the functional interfaces for the exercise.
 * <br>
 * <strong>
 * note that the example is a no sense program, it's just illustrative implementation the mentioned functional interfaces.
 * </strong>
 */
public class Main {
    private static final Float IVA = 0.19F;
    private static final Integer randomInt = new Random().nextInt();

    /**
     * Implementation of a Runnable interface.
     */
    public static void main(String[] args) {
        runnable.run();
    }


    /**
     * The constant firstCharToUpper.
     * Converts the first character of a string into its upper case.
     *
     * <strong>Note that is assumed that the first character is always a letter character</strong>
     *
     * @params String str String given to be converted.
     * @returns String converted, it only changes the first character.
     */
    final static UnaryOperator<String> firstCharToUpper = (str) -> {
        String[] splittedStr = str.split("");
        splittedStr[0] = splittedStr[0].toUpperCase();
        StringBuilder result = new StringBuilder();
        for (String string : splittedStr) {
            result.append(string);
        }
        return result.toString();
    };

    /**
     * The Calculate iva.
     */
    final static UnaryOperator<Float> calculateIVA = (cost) -> cost + (cost * IVA);

    /**
     * The constant printName.
     * Works as a string formatter that turn each word coming after a space into its to upper case.
     *
     * @params String str Name to be formatted.
     * @returns String name Given name formatted.
     */
    final static Function<String, String> printName = (name) -> {
        char[] charName = name.toLowerCase().toCharArray();
        boolean foundWord = false;
        for (int index = 0; index < charName.length; index++) {
            if (!foundWord && Character.isLetter(charName[index])) {
                charName[index] = Character.toUpperCase(charName[index]);
                foundWord = true;
            } else if (Character.isWhitespace(charName[index])) {
                foundWord = false;
            }
        }
        return String.valueOf(charName);
    };


    /**
     * Calculates the max number among two given numbers.
     *
     * @params Integer num1, Integer num2.
     * @returns Integer max of two given int numbers.
     */
    final static BiFunction<Integer, Integer, Integer> maxValueBetweenTwoNumbers = Math::max;


    /**
     * Defines if you are having lucky today.
     *
     * @params Integer number expects to be random number generated.
     * @returns String message that states if you'll be lucky today or not.
     */
    final static Consumer<Integer> amILuckyToday = (number) -> {
        System.out.println(number % 2 == 0
                ? "You'll shine like a star today!"
                : "Whoops, seems like it's not your day at all");
    };

    /**
     * Generates a random name and "state" of a woman.
     * The possible names are <strong>Diana</strong>, <strong>Sofia</strong> or <strong>Laura</strong>.
     * Their possible states are <strong>miss.</strong>, <strong>ms.</strong> or <strong>mrs.</strong>
     *
     * @returns String callable woman name.
     */
    final static Supplier<String> ladyNameGenerator = () -> {
        String[] possibleNames = {"", "Diana", "Sofia", "Laura"};
        String[] possibleTreat = {"", "miss.", "mrs.", "ms."};
        int randomChoose = (int) (Math.random() * 3) + 1;
        return possibleTreat[randomChoose] +
                " " +
                possibleNames[randomChoose];
    };

    /**
     * States if a woman name given corresponds to a married woman.
     *
     * @params String name of a woman to evaluate.
     * @returs Boolean either true or false if the woman is married or not.
     */
    final static Predicate<String> isMarriedLady = (name) -> {
        name = name.toLowerCase();
        return name.contains("mrs.");
    };

    /**
     * Example of runnable interface.
     */
    final static Runnable runnable = () -> {
        System.out.println(printName.apply("deyby ariza  loZano"));
        System.out.println(firstCharToUpper.apply("hi!, ¿how is it going?"));
        System.out.print("Are you lucky today? -> ");
        amILuckyToday.accept(randomInt);
        System.out.println();
        String lady = ladyNameGenerator.get();
        System.out.println("Aleatory lady name generated -> " + lady);
        System.out.println("Is that lady married? -> " + isMarriedLady.test(lady));
        Integer productValue = maxValueBetweenTwoNumbers.apply(
                new Random().nextInt(10, 55000),
                new Random().nextInt(10, 55000));
        System.out.println("value of a product with IVA -> " + calculateIVA.apply(productValue.floatValue())
                + " and without it -> " + productValue.floatValue());
    };
}