package stringcalculator.domain;

public class Token {
    private static final String OPERAND_PATTERN = "[0-9]+";
    private static final String OPERATOR_PATTERN = "[+\\-*/]";
    private final String token;

    public Token(String token) {
        this.token = token;
    }

    public boolean isOperand() {
        return token.matches(OPERAND_PATTERN);
    }

    public boolean isOperator() {
        return token.matches(OPERATOR_PATTERN);
    }

    public String getToken() {
        return token;
    }
}
