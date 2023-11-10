package camp.nextstep.edu.calculator;

public class StringCalculator {

    public static int calculate(String strExpressions) {
        if (isEmpty(strExpressions)) {
            throw new IllegalArgumentException("공백이나 null이 올 수 없습니다");
        }
        String[] expression = strExpressions.split(" ");
        return calculateAll(expression);
    }

    private static int calculateAll(String[] expressions) {
        int result = calculate(expressions[0], expressions[1], expressions[2]);
        for (int i = 3; i < expressions.length; i += 2) {
            result = calculate(String.valueOf(result), expressions[i], expressions[i+1]);
        }
        return result;
    }

    private static int calculate(String strLeft, String operator, String strRight) {
        if (!isValidOperator(operator)) {
            throw new IllegalArgumentException("지원하지 않는 잘못된 연산자입니다.");
        }

        int left = Integer.parseInt(strLeft);
        int right = Integer.parseInt(strRight);

        return calculate(operator, left, right);
    }

    private static boolean isValidOperator(String operator) {
        return "+".equals(operator) || "-".equals(operator)
            || "*".equals(operator) || "/".equals(operator);
    }

    private static int calculate(String operator, int left, int right) {
        if ("+".equals(operator)) {
            return left + right;
        }
        if ("-".equals(operator)) {
            return left - right;
        }
        if ("*".equals(operator)) {
            return left * right;
        }
        return left / right;
    }
    
    private static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }
}
