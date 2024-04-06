package stringCalculator;

public class StringCalculator {

    public static int splitAndCalculate(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty");
        }

        String[] tokens = expression.split(" ");
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            char operation = tokens[i].charAt(0);
            int nextNumber = Integer.parseInt(tokens[i + 1]);

            result = applyOperation(operation, result, nextNumber);
        }
        return result;
    }

    private static int applyOperation(char operation, int a, int b) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                validateNonZero(b);
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }

    private static void validateNonZero(int b) {
        if (b == 0) {
            throw new UnsupportedOperationException("Cannot divide by zero");
        }
    }
}
