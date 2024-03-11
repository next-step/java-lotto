package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private static final int FIRST = 0;
    private static final int ONE = 1;
    private static final String TOKEN_DELIMITER = " ";

    public static int calculate(String input) {
        assertInput(input);

        List<String> tokens = new ArrayList<>(Arrays.asList(input.split(TOKEN_DELIMITER)));
        while (tokens.size() > ONE) {
            int result = calculateOne(tokens);
            tokens.add(FIRST, String.valueOf(result));
        }

        return Integer.parseInt(tokens.get(FIRST));
    }

    private static void assertInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
    }

    private static int calculateOne(List<String> operands) {
        Operand left = new Operand(operands.remove(FIRST));
        Operator operator = Operator.from(operands.remove(FIRST));
        Operand right = new Operand(operands.remove(FIRST));

        return operator.compute(left, right);
    }
}
