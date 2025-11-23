package calculator;

public class StringCalculator {
    
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
        return Operator.fromString(operator).apply(left, right);
    }
}