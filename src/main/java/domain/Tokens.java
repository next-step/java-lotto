package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokens {
    private static final String DELIMITER = " ";
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력이 없습니다.";
    private static final String OPERAND_ERROR_MESSAGE = "올바른 피연산자가 아닙니다.";
    private static final String OPERATOR_ERROR_MESSAGE = "올바른 연산자가 아닙니다.";
    private final List<Token> tokens;

    public Tokens(String expression) {
        validateSize(expression);
        this.tokens = Arrays.stream(expression.split(DELIMITER))
                            .map(Token::new)
                            .collect(Collectors.toList());
        validateTokens();
    }

    private void validateSize(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    private void validateTokens() {
        for (int i = 0; i < tokens.size(); i++) {
            validateToken(i);
        }
    }

    private void validateToken(int index) {
        Token token = tokens.get(index);
        if (index % 2 == 0) {
            validateOperand(token);
            return;
        }
        validateOperator(token);
    }

    private void validateOperand(Token token) {
        if (!token.isOperand()) {
            throw new IllegalArgumentException(OPERAND_ERROR_MESSAGE);
        }
    }

    private void validateOperator(Token token) {
        if (!token.isOperator()) {
            throw new IllegalArgumentException(OPERATOR_ERROR_MESSAGE);
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
