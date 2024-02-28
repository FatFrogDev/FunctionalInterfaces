package org.globant.functionalInterfaces.trifunctionInterface;

public class Main {

    public static void main(String[] args) {
        final Integer random1 = (int) (Math.random() * 50) + 1;
        final Integer random2 = (int) (Math.random() * 50) + 1;
        final Integer random3 = (int) (Math.random() * 50) + 1;
        System.out.println("Welcome to the max random number game. \n Chose if you're betting to the 1-2-3 player");
        System.out.println("Lets see! " + maxRandomNumberGame.declareWinner.apply(random1, random2, random3));
    }
}
