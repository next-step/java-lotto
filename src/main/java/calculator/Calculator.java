package calculator;

public class Calculator {

    public static int calculate(String input) {
        if (input == null || input.trim().equals("")) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }

        String[] tokens = input.split(" ");

        int result = Integer.parseInt(tokens[0]);

        for (int i = 0; i < tokens.length - 2; i += 2) {
            int operand = Integer.parseInt(tokens[i + 2]);
            String operator = tokens[i + 1];
            result = calculate(operator, result, operand);
        }

        return result;
    }

    private static int calculate(String operator, int operand1, int operand2) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Input cannot be parsed.");
        }
    }
}
