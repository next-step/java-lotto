package stringcalculator;

public class StringCalculator {
    public static final String ENTERED_NULL_OR_EMPTY_STRING = "null을 입력하였습니다.";
    public static final String ONLY_NUMBERS_AND_OPERATORS_ALLOWED = "숫자와 사칙 연산자만 입력할 수 있습니다.";

    public int calculate(String inputString) {
        // 유효성 검사
        validationCheck(inputString);

        String[] tokens = inputString.split(" ");

        String operator = "";
        int result = 0;

        for (String token : tokens) {
            // token이 연산자일때 처리
            if (isOperator(token)) {
                operator = token;
                continue;
            }
            // token이 숫자일때 연산
            result = getCalculatedResult(operator, result, token);
        }

        return result;
    }

    private void validationCheck(String inputString) {
        if (inputString == null || inputString.length() == 0) {
            throw new IllegalArgumentException(ENTERED_NULL_OR_EMPTY_STRING);
        }

        String exp = "[\\d+\\-*/ ]+";
        if (!inputString.matches(exp)) {
            throw new IllegalArgumentException(ONLY_NUMBERS_AND_OPERATORS_ALLOWED);
        }
    }

    private boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token);
    }

    private int getCalculatedResult(String operator, int result, String token) {
        int num = Integer.parseInt(token);

        if ("".equals(operator)) {
            return num;
        }
        if ("+".equals(operator)) {
            return result + num;
        }
        if ("-".equals(operator)) {
            return result - num;
        }
        if ("*".equals(operator)) {
            return result * num;
        }
        if ("/".equals(operator)) {
            return result / num;
        }

        throw new IllegalArgumentException(ONLY_NUMBERS_AND_OPERATORS_ALLOWED);
    }
}
