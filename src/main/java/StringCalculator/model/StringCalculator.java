package StringCalculator.model;

import StringCalculator.model.calculator.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringCalculator {
    private static final int DEFAULT_VALUE = -99999;
    private static final Set<String> signs = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    private static final Calculator addCalculator = new AddCalculator();
    private static final Calculator subCalculator = new SubCalculator();
    private static final Calculator mulCalculator = new MulCalculator();
    private static final Calculator divCalculator = new DivCalculator();

    public int calculate(String input) {
        int result;
        String[] tokens;

        checkInput(input);
        tokens = input.split(" ");

        // set initial value
        checkSign(tokens[1]);
        result =  calculate(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]));

        for (int i = 3; i < tokens.length; i = i + 2) {
            checkSign(tokens[i]);
            result = calculate(result, tokens[i], Integer.parseInt(tokens[i + 1]));
        }


        return result;
    }

    private int calculate(int num1, String sign, int num2) {
        switch (sign) {
            case "+":
                return addCalculator.calculate(num1, num2);
            case "-":
                return subCalculator.calculate(num1, num2);
            case "*":
                return mulCalculator.calculate(num1, num2);
            case "/":
                return divCalculator.calculate(num1, num2);
        }

        return DEFAULT_VALUE;
    }

    private void checkInput(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("input is null");
        }

        if (input.isBlank()) {
            throw new IllegalArgumentException("input is blank");
        }
    }

    private void checkSign(String candidate) throws IllegalArgumentException {
        if (!signs.contains(candidate)) {
            throw new IllegalArgumentException("There is non-arithmetic sign");
        }
    }
}
