package calculator;

public class StringCalculator {

    public static int calculate(String expression) {
        assertInput(expression);

        Tokens tokens = new Tokens(expression);
        return tokens.calculate();
    }

    private static void assertInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
    }
}
