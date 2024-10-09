package domain;

public class Token {
    private static final String OPERAND_ERROR_MESSAGE = "올바른 피연산자가 아닙니다.";
    private static final String OPERATOR_ERROR_MESSAGE = "올바른 연산자가 아닙니다.";
    private static final String OPERAND_PATTERN = "[0-9]+";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";
    private final String token;

    public Token(String token) {
        this.token = token;
    }

    public void validateOperand() {
        if (!isOperand()) {
            throw new IllegalArgumentException(OPERAND_ERROR_MESSAGE);
        }
    }

    public void validateOperator() {
        if (!isOperator()) {
            throw new IllegalArgumentException(OPERATOR_ERROR_MESSAGE);
        }
    }

    private boolean isOperand() {
        return token.matches(OPERAND_PATTERN);
    }

    private boolean isOperator() {
        return token.matches(OPERATOR_PATTERN);
    }

    public String getToken() {
        return token;
    }
}
