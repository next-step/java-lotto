package step1.calculator.controller;

import step1.calculator.model.Operation;

public class CalculatorApp {

    public int calculates(String input) {
        String[] tokens = input.split(" ");
        return calculates(tokens);
    }

    public int calculates(String[] tokens) {
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            result = calculate(result, tokens[i], Integer.parseInt(tokens[i + 1]));
        }
        return result;
    }

    private int calculate(int result, String operator, int number) {
        return Operation.OPERATIONS.get(operator).calculate(result, number);
    }

}
