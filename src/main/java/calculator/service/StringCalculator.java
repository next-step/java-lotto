package calculator.service;

import calculator.domain.StringNumber;
import calculator.domain.StringOperator;

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

    private static StringNumber calculate(String[] s) {
        StringNumber stringNumber = new StringNumber(s[0]);
        for (int i = 1; i < s.length; i += 2) {
            stringNumber = stringNumber.calculate(new StringOperator(s[i]), new StringNumber(s[i + 1]));
        }
        return stringNumber;
    }
}
