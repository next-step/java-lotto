package calculator;

public class StringCalculator {

    public static int calculate(String strTokens) {
        assertInput(strTokens);

        Tokens tokens = new Tokens(strTokens);
        while (!tokens.hasResult()) {
            int result = tokens.firstExpression().calculate();
            tokens.replaceFirstExpressionWithResult(result);
        }
        return tokens.result();
    }

    private static void assertInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
    }
}
