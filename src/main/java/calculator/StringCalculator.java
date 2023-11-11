package calculator;

import static calculator.REGEX.NUMBER_PATTERN;
import static calculator.REGEX.OPERATION_PATTERN;

public class StringCalculator {
    public static final String INVALID_TOKEN_MSG = "올바른 입력이 아닙니다.";
    private static final String NULL_EMPTY_MSG= "입력 값이 null 이거나 빈 공백 문자일 수 없습니다.";
    public static final String SPACE = " ";

    private Operands operands;
    private Operations operations;

    public StringCalculator(final String inputText) {
        validationInput(inputText);

        final String[] tokens = splitToken(inputText);

        this.operations = new Operations(tokens);
        this.operands = new Operands(tokens);
    }

    private String[] splitToken(final String inputText) {
        final String[] tokens = inputText.split(SPACE);

        for (String token : tokens) {
            validationToken(token);
        }
        return tokens;
    }

    private void validationToken(final String token) {
        if (isNotNumberAndInvalidOperation(token)) {
            throw new IllegalArgumentException(INVALID_TOKEN_MSG);
        }
    }

    private boolean isNotNumberAndInvalidOperation(final String token) {
        return !NUMBER_PATTERN.matcher(token).find() && !OPERATION_PATTERN.matcher(token).find();
    }

    private void validationInput(final String inputText) {
        if (isNullOrEmpty(inputText)) {
            throw new IllegalArgumentException(NULL_EMPTY_MSG);
        }
    }

    private static boolean isNullOrEmpty(final String inputText) {
        return inputText == null || inputText.isBlank();
    }

    public int calculate() {
        return this.operations.calculate(this.operands);
    }
}
