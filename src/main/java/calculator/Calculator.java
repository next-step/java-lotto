package calculator;

import calculator.operator.OperatorRepository;
import calculator.operator.OperatorStrategy;

public class Calculator {

    public static final String INPUT_TEXT_EXCEPTION = "문자열이 빈 값이거나, 공백만 존재합니다.";

    private final OperatorRepository operatorRepository;

    public Calculator(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
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
        return findOperator(textOperator).calculate(sum, operand);
    }

    private OperatorStrategy findOperator(String textOperator) {
        return operatorRepository.findOperator(textOperator);
    }
}
