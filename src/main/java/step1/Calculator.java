package step1;

import java.util.*;

public class Calculator {
    private final Map<String, Operation> operations;
    private boolean isNextNegative;

    public Calculator() {
        this.operations = new HashMap<>();
        operations.put("+", new Addition());
        operations.put("-", new Subtraction());
        operations.put("*", new Multiplication());
        operations.put("/", new Division());
    }

    public int calculate(String input) {
        InputValidator.isNotOrEmpty(input);
        String[] tokens = input.split(" ");
        int result = 0;
        isNextNegative = false;

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            InputValidator.nonArithmeticOperator(token);
            result = (InputValidator.isOperation(token)) ? performOperation(token, result, tokens[++i]) : performCalculation(result, token);
        }

        return result;
    }
    private int performOperation(String token, int num1, String token2) {
        isNextNegative = false;
        int num2 = Integer.parseInt(token2);
        return operations.get(token).calculate(num1, num2);
    }

    private int performCalculation(int result, String token) {
        int num = Integer.parseInt(token);
        if (isNextNegative) {
            num = -num;
            isNextNegative = false;
        }
        return calculateToken(result, num);
    }

    private int calculateToken(int result, int num) {
        return result == 0 ? num : operations.get("+").calculate(result, num);
    }

}