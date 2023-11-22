package calculator;

import calculator.operator.Operator;
import java.util.List;

public class Calculator {

    public static final String INPUT_TEXT_EXCEPTION = "문자열이 빈 값이거나, 공백만 존재합니다.";
    public static final String INPUT_OPERATOR_EXCEPTION = "입력하신 연산자가 사칙 연산 연산자가 아닙니다.";

    private final List<Operator> operators;

    public Calculator(List<Operator> operators) {
        this.operators = operators;
    }

    public long calculate(String text) {
        validateText(text);

        String[] splitText = text.split(" ");
        long sum = Long.parseLong(splitText[0]);

        for (int i = 1; i < splitText.length; i += 2) {
            long operand = Long.parseLong(splitText[i + 1]);
            sum = calculateWithOperator(splitText[i], sum, operand);
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

    private long calculateWithOperator(String textOperator, long sum, long operand) {
        return operators.stream()
                .filter(operator -> operator.match(textOperator))
                .findFirst()
                .map(operator -> operator.calculate(sum, operand))
                .orElseThrow(() -> new IllegalArgumentException(INPUT_OPERATOR_EXCEPTION));
    }
}
