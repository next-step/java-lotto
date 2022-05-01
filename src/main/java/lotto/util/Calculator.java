package lotto.util;

import lotto.exception.NotSupportInstanceException;

import java.text.DecimalFormat;

public class Calculator {

    private static final String DECIMAL_PATTERN = "#.##";
    private static final DecimalFormat df = new DecimalFormat(DECIMAL_PATTERN);

    private Calculator() {
        throw new NotSupportInstanceException();
    }

    public static String divide(double number1, double number2) {
        return df.format(number1 / number2);
    }
}
