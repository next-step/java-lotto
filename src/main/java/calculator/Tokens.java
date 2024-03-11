package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Tokens {

    private final List<Token> tokens;

    private static final String TOKEN_DELIMITER = " ";
    private static final int ONE = 1;
    private static final int FIRST = 0;

    public Tokens(String expression) {
        this(
            Arrays.stream(expression.split(TOKEN_DELIMITER))
                .map(Token::of)
                .collect(Collectors.toList())
        );
    }

    public Tokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public int calculate() {
        while (tokens.size() > ONE) {
            int result = calculateOne(tokens);
            tokens.add(FIRST, new Operand(result));
        }
        return Operand.of(tokens.get(FIRST)).value();
    }

    private static int calculateOne(List<Token> tokens) {
        Operand left = Operand.of(tokens.remove(FIRST));
        Operator operator = Operator.of(tokens.remove(FIRST));
        Operand right = Operand.of(tokens.remove(FIRST));
        return operator.compute(left, right);
    }
}
