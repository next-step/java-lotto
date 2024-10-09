package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Tokens {
    private static final String DELIMITER = " ";
    private static final String EMPTY_INPUT_ERROR_MESSAGE = "입력이 없습니다.";
    private final List<Token> tokens;

    public Tokens(String expression) {
        this.tokens = expression.isEmpty() ? Collections.emptyList() : Arrays.stream(expression.split(DELIMITER))
                                                                             .map(Token::new)
                                                                             .collect(Collectors.toList());

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
            tokens.get(i).validateOperand();
            tokens.get(i + 1).validateOperator();
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
