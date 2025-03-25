package calculator;

import calculator.exception.UnexpectedOperatorException;

public class Calculator {

    public int calculate(String input) {
        String[] tokens = input.split(" ");
        int left = Integer.parseInt(tokens[0]);
        String operator = tokens[1];
        int right = Integer.parseInt(tokens[2]);

        switch (operator) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
        }

        throw new UnexpectedOperatorException();
    }

}
