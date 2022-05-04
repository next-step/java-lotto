package lotto.util;

import lotto.exception.NotSupportInstanceException;

public class Calculator {

    private Calculator() {
        throw new NotSupportInstanceException();
    }

    public static double divide(double number1, double number2) {
        return number1 / number2;
    }
}
