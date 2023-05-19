package stringcalculator;

public class StringCalculator {
    public static final String ERRMSG_ENTERED_NULL_OR_EMPTY_STRING = "null을 입력하였습니다.";
    public static final String ERRMSG_ONLY_NUMBERS_AND_OPERATORS_ALLOWED = "숫자와 사칙 연산자만 입력할 수 있습니다.";

    public static final String REGEXP_NUMBERS_AND_OPERATORS = "[\\d+\\-*/ ]+";

    public int main(String inputString) {
        // 유효성 검사
        validationCheck(inputString);

        return calculate(inputString);
    }

    private void validationCheck(String inputString) {
        if (inputString == null || inputString.length() == 0) {
            throw new IllegalArgumentException(ERRMSG_ENTERED_NULL_OR_EMPTY_STRING);
        }

        if (!inputString.matches(REGEXP_NUMBERS_AND_OPERATORS)) {
            throw new IllegalArgumentException(ERRMSG_ONLY_NUMBERS_AND_OPERATORS_ALLOWED);
        }
    }

    private int calculate(String inputString) {
        return calculate(inputString, "", 0);
    }

    private int calculate(String inputString, String operator, int result) {
        String[] tokens = inputString.split(" ");

        for (String token : tokens) {
            // token이 연산자일때 처리
            operator = getOperator(operator, token);

            // token이 숫자일때 연산
            result = getCalculatedResult(operator, token, result);
        }

        return result;
    }

    private String getOperator(String operator, String token) {
        return isOperator(token) ? token : operator;
    }

    private boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token);
    }

    private int getCalculatedResult(String operator, String token, int result) {
        if ((isOperator(token))) {
            return result;
        }

        int num = Integer.parseInt(token);

        if ("".equals(operator)) {
            return num;
        }

        Operator op = Operator.fromSymbol(operator);
        return op.apply(result, num);
    }
}
