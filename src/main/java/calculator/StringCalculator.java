package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public static int calculate(String text) {
        List<String> tokens = split(text);

        return calculate(tokens);
    }

    public static List<String> split(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(String.format("input text : [%s], 입력값에 null 이거나 빈 공백 문자는 올수없습니다.", text));
        }
        return Arrays.asList(text.split(DELIMITER));
    }

    private static int calculate(List<String> tokens) {
        int result = Integer.parseInt(tokens.get(0));
        for (int i = 1; i < tokens.size() - 1; i += 2) {
            String operator = getOperator(tokens.get(i));
            int operand = Integer.parseInt(tokens.get(i + 1));
            result = operate(result, operand, operator);
        }
        return result;
    }

    private static String getOperator(String token) {
        isValidOperator(token);
        return token;
    }

    public static boolean isValidOperator(String operator) {
        if ("+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator)) {
            return true;
        }
        throw new IllegalArgumentException(String.format("input operator : [%s], 사칙연산 기호만 올수 있습니다.", operator));
    }

    private static int operate(int preNum, int currentNum, String operator) {
        if ("+".equals(operator)) {
            return sum(preNum, currentNum);
        }
        if ("-".equals(operator)) {
            return sub(preNum, currentNum);
        }
        if ("*".equals(operator)) {
            return multi(preNum, currentNum);
        }
        if ("/".equals(operator)) {
            return divide(preNum, currentNum);
        }
        throw new IllegalArgumentException(String.format("input operator : [%s], 처리할수 없는 연산자가 넘어왔다", operator));
    }

    private static int sum(int a, int b) {
        return a + b;
    }

    private static int sub(int a, int b) {
        return a - b;
    }

    private static int divide(int a, int b) {
        return a / b;
    }

    private static int multi(int a, int b) {
        return a * b;
    }
}
