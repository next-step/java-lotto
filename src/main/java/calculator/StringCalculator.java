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
        if (operator.equals("+")) {
            return Calculator.add(left, right);
        }
        if (operator.equals("-")) {
            return Calculator.subtract(left, right);
        }
        if (operator.equals("*")) {
            return Calculator.multiply(left, right);
        }
        if (operator.equals("/")) {
            return Calculator.divide(left, right);
        }
        throw new IllegalArgumentException("연산 불가합니다");
    }

}
