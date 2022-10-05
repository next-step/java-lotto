package com.nextstep.lotto;

import java.util.List;

public class StringCalculator {

    private StringCalculator() {}

    public static int calculate(String polynomialString) {
        Polynomial polynomial = new Polynomial(polynomialString);
        return calculate(polynomial);
    }

    private static int calculate(Polynomial polynomial) {
        int result = parseToInt(polynomial.getTokenAt(0));
        for (int i = 1; i < polynomial.size(); i+=2) {
            Operator operator = Operator.of(polynomial.getTokenAt(i));
            int rightOperand = parseToInt(polynomial.getTokenAt(i+1));
            result = operator.apply(result, rightOperand);
        }
        return result;
    }

    private static int parseToInt(String numericString) {
        try {
            return Integer.parseInt(numericString);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("expect integer but found \'" + numericString + "\'");
        }
    }
}
