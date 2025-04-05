package calculator.token;

import calculator.token.impl.NumberToken;
import calculator.token.impl.OperatorToken;
import util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Tokens {

    private static final int TOKEN_GROUP_SIZE = 2;
    private static final int ODD = 1;
    private static final String SEPERATOR = "\\s+";

    private final List<Token> tokens;

    public Tokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public static Tokens from(final String input) {
        InputValidator.validateInput(input);

        String[] rawTokens = input.trim().split(SEPERATOR);
        List<Token> result = new ArrayList<>();

        for (int i = 0; i < rawTokens.length; i++) {
            Token token = (i % 2 == 0) ?
                    new NumberToken(rawTokens[i]) : new OperatorToken(rawTokens[i]);
            result.add(token);
        }

        return new Tokens(result);
    }

    public int evaluate() {
        int result = ((NumberToken) tokens.get(0)).getValue();

        for (int i = 1; i < tokens.size(); i += 2) {
            OperatorToken operatorToken = (OperatorToken) tokens.get(i);
            NumberToken right = (NumberToken) tokens.get(i + 1);
            result = operatorToken.apply(result, right);
        }

        return result;
    }

    public int size() {
        return tokens.size();
    }

    public boolean isOddSize() {
        return tokens.size() % TOKEN_GROUP_SIZE == ODD;
    }
}
