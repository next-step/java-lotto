package calculator;

public class Calculator {

    public static final String INPUT_TEXT_EXCEPTION = "문자열이 빈 값이거나, 공백만 존재합니다.";
    public static final String INPUT_OPERATOR_EXCEPTION = "입력하신 연산자가 사칙 연산 연산자가 아닙니다.";

    public long calculate(String text) {
        validateText(text);

        String[] splitText = text.split(" ");

        long sum = Long.parseLong(splitText[0]);;

        for (int i = 1; i < splitText.length; i += 2) {
            String operator = getOperator(splitText[i]);
            long secondOperand = Long.parseLong(splitText[i + 1]);

            if (operator.equals("+")) {
                sum += secondOperand;
                continue;
            }

            if (operator.equals("-")) {
                sum -= secondOperand;
                continue;
            }

            if (operator.equals("*")) {
                sum *= secondOperand;
                continue;
            }

            if (operator.equals("/")) {
                sum /= secondOperand;
            }
        }
        return sum;
    }

    private void validateText(String text) {
        if (isEmptyOrBlank(text)) {
            throw new IllegalArgumentException(INPUT_TEXT_EXCEPTION);
        }
    }

    private boolean isEmptyOrBlank(String text) {
        return text == null || text.isEmpty() || text.isBlank();
    }

    private String getOperator(String operator) {
        validateOperator(operator);
        return operator;
    }

    private void validateOperator(String operator) {
        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            throw new IllegalArgumentException(INPUT_OPERATOR_EXCEPTION);
        }
    }
}
