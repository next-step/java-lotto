package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokens {
    private static final String DELIMITER = " ";
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력이 없습니다.";
    private final List<Token> tokens;

    public Tokens(String expression) {
        validateSize(expression);
        this.tokens = Arrays.stream(expression.split(DELIMITER))
                            .map(Token::new)
                            .collect(Collectors.toList());
        validateTokens();
    }

    private void validateSize(String expression) {
        if (expression.isEmpty()) {
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
            token.validateOperand();
            return;
        }
        token.validateOperator();
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
