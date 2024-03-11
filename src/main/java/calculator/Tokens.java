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
        return ((Operand) tokens.get(FIRST)).value();
    }

    private static int calculateOne(List<Token> tokens) {
        try {
            Operand left = (Operand) tokens.remove(FIRST);
            Operator operator = (Operator) tokens.remove(FIRST);
            Operand right = (Operand) tokens.remove(FIRST);
            return operator.compute(left, right);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("연산자 또는 피연산자가 잘못된 위치에 있음");
        }
    }
}
