package stringCalculator.domains;

public class StringCalculator {
    public static int calculate(String input) {
        validateIsNotBlank(input);
        return calculate(input.split(" "));
    }

    private static int calculate(String[] expression) {
        validateExpressionLength(expression.length);
        Operand o1 = new Operand(expression[0]);
        int result = o1.getInt();
        for (int i = 1; i < expression.length; i = i + 2) {
            Operator operator = new Operator(expression[i]);
            Operand o2 = new Operand(expression[i + 1]);
            result = operator.operate(result, o2.getInt());
        }
        return result;
    }

    private static void validateExpressionLength(int length) {
        if (length < 3 || length % 2 == 0) {
            throw new IllegalArgumentException("수식 오류");
        }
    }

    private static void validateIsNotBlank(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("빈 값 불가");
        }
    }
}
