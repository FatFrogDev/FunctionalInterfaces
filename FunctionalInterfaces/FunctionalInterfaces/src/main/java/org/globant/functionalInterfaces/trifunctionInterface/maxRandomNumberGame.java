package org.globant.functionalInterfaces.trifunctionInterface;

public class maxRandomNumberGame {

    /**
     * States a winner of a game with three given numbers, a winner is the one that has the bigger number.
     * @Param num1 First number. It'll be compared
     * @Param num2 Second number. It'll be compared
     * @Param num3 Third number. It'll be compared
     * @returns String a winner | tie declaration.
     */
    final static TriFunctionalInterface<Integer, Integer, Integer, String> declareWinner = (num1, num2, num3) -> {
        if (num1 > num2 && num1 > num3) {
            return "Winner is the  1st player";
        } else if (num2 > num1 && num2 > num3) {
            return "Winner is the  2nd player";
        } else if (num3 > num1 && num3 > num2) {
            return "Winner is the  3rd player";
        } else {
            return "Seems it's a tie!";
        }
    };

}
