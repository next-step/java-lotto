package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {

    private static final int FIRST = 0;
    private static final int ONE = 1;
    private static final String TOKEN_DELIMITER = " ";

    public static int calculate(String input) {
        assertInput(input);

        List<Token> tokens = Arrays.stream(input.split(TOKEN_DELIMITER))
            .map(Token::of)
            .collect(Collectors.toList());

        while (tokens.size() > ONE) {
            int result = calculateOne(tokens);
            tokens.add(FIRST, new Operand(result));
        }

        return ((Operand) tokens.get(FIRST)).value();
    }

    private static void assertInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
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
