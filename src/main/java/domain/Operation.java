package domain;

public enum Operation {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION;

    public static Operation fromString(String input) {
        verifyNotEmpty(input);

        switch (input) {
            case "+":
                return ADDITION;
            case "-":
                return SUBTRACTION;
            case "*":
                return MULTIPLICATION;
            case "/":
                return DIVISION;
            default:
                throw new IllegalArgumentException("Invalid operator: " + input);
        }
    }

    private static void verifyNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Invalid operator: " + input);
        }
    }
}
