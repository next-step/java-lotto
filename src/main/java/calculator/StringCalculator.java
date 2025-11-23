package calculator;

public class StringCalculator {

    private static final String ADD = "+";
    private static final String SUBTRACT = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String ERROR_INVALID_OPERATOR = "연산 불가합니다";

    public static int calculate(String[] tokens) {
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);
            result = applyOperator(operator, result, operand);
        }
        return result;
    }

    private static int applyOperator(String operator, int left, int right) {
        if (operator.equals(ADD)) return Calculator.add(left, right);
        if (operator.equals(SUBTRACT)) return Calculator.subtract(left, right);
        if (operator.equals(MULTIPLY)) return Calculator.multiply(left, right);
        if (operator.equals(DIVIDE)) return Calculator.divide(left, right);
        throw new IllegalArgumentException(ERROR_INVALID_OPERATOR);
    }
}