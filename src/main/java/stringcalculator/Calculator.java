package stringcalculator;

import java.util.HashMap;

public class Calculator {
    private final HashMap<String, Operation> operations;

    public Calculator() {
        this.operations = new HashMap<>();
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public int calculate(String input) {
        InputValidator.validateBlank(input);
        String[] tokens = input.split(" ");

        String firstToken = tokens[0];
        InputValidator.validateNumber(firstToken);
        int result = Integer.parseInt(firstToken);

        for (int i = 1; i < tokens.length; i+=2) {
            String operator = tokens[i];
            InputValidator.validateOperator(operator);

            String number = tokens[i + 1];
            InputValidator.validateNumber(number);

            int operand = Integer.parseInt(number);
            result = performCalculation(result, operator, operand);
        }

        return result;
    }

    private int performCalculation(int preValue, String operator, int operand) {
        return operations.get(operator).calculate(preValue, operand);
    }
}
