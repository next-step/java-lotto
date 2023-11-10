package camp.nextstep.edu.calculator;

public class StringCalculator {

    private static final int FIRST_LEFT_IDX = 0;
    private static final int FIRST_OPERATOR_IDX = 1;
    private static final int FIRST_RIGHT_IDX = 2;
    private static final int SECOND_OPERATOR_IDX = 3;
    private  static final int NEXT_OPERATOR_GAP = 2;

    public static int calculate(String strExpressions) {
        if (isEmpty(strExpressions)) {
            throw new IllegalArgumentException("공백이나 null이 올 수 없습니다");
        }
        String[] expression = strExpressions.split(" ");
        return calculateAll(expression);
    }

    private static int calculateAll(String[] expressions) {
        int result = calculate(expressions[FIRST_LEFT_IDX],
            expressions[FIRST_OPERATOR_IDX],
            expressions[FIRST_RIGHT_IDX]
        );

        for (int i = SECOND_OPERATOR_IDX; i < expressions.length; i += NEXT_OPERATOR_GAP) {
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
