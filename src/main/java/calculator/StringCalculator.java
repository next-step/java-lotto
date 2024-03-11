package calculator;

public class StringCalculator {

    public static int calculate(String strExpression) {
        assertInput(strExpression);

        Operand expression = CalculatedExpression.from(strExpression);
        return expression.value();
    }

    private static void assertInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
    }
}
