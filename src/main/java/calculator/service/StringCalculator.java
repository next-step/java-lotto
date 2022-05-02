package calculator.service;

import calculator.domain.Operator;
import calculator.domain.StringNumber;

public class StringCalculator {
    private static final String BLANK_INPUT_EXCEPTION = "입력은 빈칸일 수 없습니다.";
    private static final String DELIMITER = " ";

    public static StringNumber splitStringAndCalculate(String input) {
        validateInput(input);
        String[] numberAndOperator = input.split(DELIMITER);
        return calculate(numberAndOperator);
    }

    private static void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION);
        }
    }

    private static StringNumber calculate(String[] splitInput) {
        StringNumber stringNumber = new StringNumber(splitInput[0]);
        for (int index = 1; index < splitInput.length; index += 2) {
            stringNumber = stringNumber.calculate(Operator.findOperatorFromSymbol(splitInput[index]), new StringNumber(splitInput[index + 1]));
        }
        return stringNumber;
    }
}
