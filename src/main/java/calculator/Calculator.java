package calculator;

public class Calculator {

    public static final String INPUT_TEXT_EXCEPTION = "문자열이 빈 값이거나, 공백만 존재합니다.";
    public static final String INPUT_OPERATOR_EXCEPTION = "입력하신 연산자가 사칙 연산 연산자가 아닙니다.";

    public long calculate(String text) {
        validateText(text);

        String[] splitText = text.split(" ");
        long firstOperand = Long.parseLong(splitText[0]);
        String operator = getOperator(splitText);
        long secondOperand = Long.parseLong(splitText[2]);

        if (operator.equals("+")) {
            return firstOperand + secondOperand;
        }

        if (operator.equals("-")) {
            return firstOperand - secondOperand;
        }

        if (operator.equals("*")) {
            return firstOperand * secondOperand;
        }

        return firstOperand / secondOperand;
    }

    private void validateText(String text) {
        if (isEmptyOrBlank(text)) {
            throw new IllegalArgumentException(INPUT_TEXT_EXCEPTION);
        }
    }

    private boolean isEmptyOrBlank(String text) {
        return text == null || text.isEmpty() || text.isBlank();
    }

    private String getOperator(String[] splitText) {
        String operator = splitText[1];
        validateOperator(operator);
        return operator;
    }

    private void validateOperator(String operator) {
        if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")) {
            throw new IllegalArgumentException(INPUT_OPERATOR_EXCEPTION);
        }
    }
}
