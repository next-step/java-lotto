package main.string_calculator.util;

import main.string_calculator.exception.NotEssence;

public class NumberUtil {

    private NumberUtil() {
        throw new AssertionError();
    }

    public static Integer isEssence(Integer firstNumber, Integer secondNumber) {
        double number = (double) firstNumber / secondNumber;
        if (number % 1 == 0) {
            return (int) number;
        }
        throw new NotEssence();
    }
}
