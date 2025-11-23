package calculator;

public class StringCalculator {

    public static String[] split(String s) {
        return s.trim().split("\\s+");
    }

    public static boolean validateSequence(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (invalidToken(tokens[i], i)) {
                throw new IllegalArgumentException("연산 순서가 바르지 않습니다");
            }
        }
        return true;
    }

    public static int calculate(String[] tokens) {
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);
            result = applyOperator(operator, result, operand);
        }
        return result;
    }

    private static boolean invalidToken(String token, int i) {
        if (i % 2 == 0 && token.matches("[1-9][0-9]*")) {
            return false;
        }
        if (i % 2 != 0 && token.matches("[+\\-*/]")) {
            return false;
        }
        return true;
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
