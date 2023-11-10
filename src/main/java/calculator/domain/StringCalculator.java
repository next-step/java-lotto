package calculator.domain;

import java.util.List;

public class StringCalculator {
    private final String NULL_EMPTY_MSG= "입력 값이 null이거나 빈 공백 문자일 수 없습니다.";

    private List<String> operands;
    public StringCalculator(final String inputText) {
        operands = initOperands(inputText);
    }

    private List<String> initOperands(final String inputText) {
        if (isNullOrEmpty(inputText)) {
            throw new IllegalArgumentException(NULL_EMPTY_MSG);
        }

        return null;
    }

    private static boolean isNullOrEmpty(final String inputText) {
        return inputText == null || inputText.isBlank();
    }
}
