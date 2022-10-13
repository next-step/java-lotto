package calculator.util;

import calculator.exception.NotEssenceException;
import calculator.exception.ValidateNumberException;

public class NumberUtil {

    private NumberUtil() {
        throw new AssertionError();
    }

    public static Integer isEssence(Integer firstNumber, Integer secondNumber) {
        double number = (double) firstNumber / secondNumber;
        if (number % 1 == 0) {
            return (int) number;
        }
        throw new NotEssenceException();
    }

    public static Integer isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new ValidateNumberException();
        }
    }
}
