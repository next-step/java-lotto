package calculator.domain;

import calculator.domain.exception.UnexpectedOperatorException;

public class Calculator {

    public int calculate(String input) {

        String[] tokens = input.split(" ");

        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int right = Integer.parseInt(tokens[i + 1]);
            switch (operator) {
                case "+":
                    result += right;
                    break;
                case "-":
                    result -= right;
                    break;
                case "*":
                    result *= right;
                    break;
                case "/":
                    result /= right;
                    break;
                default:
                    throw new UnexpectedOperatorException();
            }
        }
        return result;
    }
}
