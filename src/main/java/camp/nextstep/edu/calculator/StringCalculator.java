package camp.nextstep.edu.calculator;

public class StringCalculator {

    public static int calculate(String strExpression) {
        if (isEmpty(strExpression)) {
            throw new IllegalArgumentException("공백이나 null이 올 수 없습니다");
        }
        String[] expression = strExpression.split(" ");
        return calculate(expression);
    }

    private static int calculate(String[] oneExpression) {
        String operator = oneExpression[1];
        int left = Integer.parseInt(oneExpression[0]);
        int right = Integer.parseInt(oneExpression[2]);

        return calculate(operator, left, right);
    }

    private static int calculate(String operator, int left, int right) {
        if ("+".equals(operator)) {
            return plus(left, right);
        }
        if ("-".equals(operator)) {
            return minus(left, right);
        }
        if ("*".equals(operator)) {
            return multiply(left, right);
        }
        throw new IllegalArgumentException("지원하지 않는 잘못된 연산자입니다.");
    }

    private static int plus(int left, int right) {
        return left + right;
    }

    private static int minus(int left, int right) {
        return left - right;
    }

    private static int multiply(int left, int right) {
        return left * right;
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }
}
