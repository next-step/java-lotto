package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokens {
    private final List<Token> tokens;

    public Tokens(String[] tokens) {
        this.tokens = Arrays.stream(tokens)
                .map(Token::create)
                .collect(Collectors.toList());
    }

    public int sum() {
        return tokens.stream()
                .map(Token::parseInt)
                .reduce(0, Integer::sum);
    }
}
