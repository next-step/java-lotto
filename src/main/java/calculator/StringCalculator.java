package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final String DELIMITER = " ";

    public static List<String> split(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException(String.format("input text : [%s], 입력값에 null 이거나 빈 공백 문자는 올수없습니다.", text));
        }
        return Arrays.asList(text.split(DELIMITER));
    }

    public static boolean isValidOperator(String operator) {
        if ("+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator)) {
            return true;
        }
        throw new IllegalArgumentException(String.format("input operator : [%s], 사칙연산 기호만 올수 있습니다.", operator));
    }

    public static int calculate(String text) {
        List<String> tokens = split(text);

        return getResult(tokens);
    }

    private static int getResult(List<String> tokens) {
        int result = 0;
        int currenNum;
        String operator;

        int preNum = Integer.parseInt(tokens.get(0));
        for (int i = 1; i < tokens.size() - 1; i += 2) {
            operator = getOperator(tokens.get(i));
            currenNum = Integer.parseInt(tokens.get(i + 1));
            if ("+".equals(operator)) {
                result = sum(preNum, currenNum);
            }
            System.out.printf("preNum : %d, operator : %s, currentNum : %d, result : %d%n", preNum, operator, currenNum, result);
            preNum = result;
        }
        return result;
    }

    private static String getOperator(String token) {
        isValidOperator(token);
        return token;
    }

    private static int sum(int a, int b) {
        return a + b;
    }
}
