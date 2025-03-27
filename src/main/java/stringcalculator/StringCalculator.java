package stringcalculator;

public class StringCalculator {

    public int calculate(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("Input cannot be null or blank");
        String[] tokens = input.trim().split(" ");
        if (tokens.length % 2 == 0)
            throw new IllegalArgumentException("Invalid input format: token count must be odd");
        validateTokens(tokens);
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2)
            result = applyOperation(result, tokens[i], Integer.parseInt(tokens[i + 1]));
        return result;
    }

    private void validateTokens(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0 && !isNumber(tokens[i]))
                throw new IllegalArgumentException("Expected a number at position " + i + ": " + tokens[i]);
            if (i % 2 != 0 && !isOperator(tokens[i]))
                throw new IllegalArgumentException("Invalid operator at position " + i + ": " + tokens[i]);
        }
    }

    private boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    int applyOperation(int a, String op, int b) {
        if ("+".equals(op)) return add(a, b);
        if ("-".equals(op)) return subtract(a, b);
        if ("*".equals(op)) return multiply(a, b);
        if ("/".equals(op)) return divide(a, b);
        throw new IllegalArgumentException("Invalid operator: " + op);
    }

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }
}