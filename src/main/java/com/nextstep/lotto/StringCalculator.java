package com.nextstep.lotto;

import java.util.List;

public class StringCalculator {

    private StringCalculator() {}

    public static int calculate(String polynomial) {
        List<String> tokens = split(polynomial);
        validation(tokens);
        return calculate(tokens);
    }

    private static List<String> split(String polynomial) {
        return List.of(polynomial.split(" "));
    }

    private static void validation(List<String> tokens) {
        if(tokens.size()<3) {
            throw new IllegalArgumentException("polynomial must have at least 3 tokens (leftOperand, operator, rightOperand)");
        }
    }

    private static int calculate(List<String> tokens) {
        int result = parseToInt(tokens.get(0));
        for (int i = 1; i < tokens.size(); i+=2) {
            Operator operator = Operator.of(tokens.get(i));
            int rightOperand = parseToInt(tokens.get(i+1));
            result = operator.apply(result, rightOperand);
        }
        return result;
    }

    private static int parseToInt(String numericString) {
        try {
            return Integer.parseInt(numericString);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("expect integer but found " + numericString);
        }
    }
}
