package calculator.service;

import calculator.code.MathSign;

public class NumericCalculator {

    public int calculate(int numberA,
                         int numberB,
                         MathSign mathSign) {
        if (mathSign.equals(MathSign.PLUS))
            return sum(numberA, numberB);
        if (mathSign.equals(MathSign.MINUS))
            return difference(numberA, numberB);
        if (mathSign.equals(MathSign.MULTIPLY))
            return product(numberA, numberB);
        return quotient(numberA, numberB);
    }
    private int sum(int numberA,
                    int numberB) {
        return numberA + numberB;
    }

    private int difference(int numberA,
                           int numberB) {
        return numberA - numberB;
    }

    private int product(int numberA,
                        int numberB) {
        return numberA * numberB;
    }

    private int quotient(int numberA,
                         int numberB) {
        return numberA / numberB;
    }
}
