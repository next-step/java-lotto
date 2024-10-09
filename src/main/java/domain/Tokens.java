package domain;

import java.util.List;

public class Tokens {
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력이 없습니다.";
    private static final String OPERAND_ERROR_MESSAGE = "올바른 피연산자가 아닙니다.";
    private static final String OPERATOR_ERROR_MESSAGE = "올바른 연산자가 아닙니다.";
    private static final String OPERAND_PATTERN = "[0-9]+";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";
    private final List<String> tokens;

    public Tokens(String expression) {
        this.tokens = List.of(expression.split(" "));
    }

    public void validate() {
        checkEmptyInput();
        checkTokens();
    }

    private void checkEmptyInput() {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    private void checkTokens() {
        for (int i = 0; i < tokens.size(); i += 2) {
            validateToken(tokens.get(i), OPERAND_PATTERN, OPERAND_ERROR_MESSAGE);
            validateToken(tokens.get(i + 1), OPERATOR_PATTERN, OPERATOR_ERROR_MESSAGE);
        }
    }

    private void validateToken(String token, String pattern, String errorMessage) {
        if (!token.matches(pattern)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
