package main.string_calculator.util;

import main.string_calculator.exception.NotEssence;
import main.string_calculator.exception.ValidateNumber;

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

    public static Integer isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ValidateNumber();
        }
    }

    public static Boolean isOdd(Integer i) {
        return i % 2 == 0;
    }
}
