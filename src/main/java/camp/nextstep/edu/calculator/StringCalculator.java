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
        int left = Integer.parseInt(oneExpression[0]);
        int right = Integer.parseInt(oneExpression[2]);
        return left + right;
    }

    private static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }
}
