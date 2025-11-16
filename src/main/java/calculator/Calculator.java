package calculator;

public class Calculator {

    public static int calculate(String expression) {
        validate(expression);
        return computeResult(parseExpression(expression));
    }

    private static void validate(String expression) {
        if (expression == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
        if (expression.trim().isEmpty()) {
            throw new IllegalArgumentException("공백 혹은 빈문자열은 입력할 수 없습니다.");
        }
    }

    private static String[] parseExpression(String expression) {
        return expression.split(" ");
    }

    private static int computeResult(String[] tokens) {
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int operand = Integer.parseInt(tokens[i + 1]);
            result = Operator.calculate(result, operand, operator);
        }
        return result;
    }
}
