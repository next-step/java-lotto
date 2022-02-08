package stringcalculator.domain;

import java.util.List;

public class StringCalculator {

    private static final int EMPTY_VALUE = 0;

    public StringCalculator() {

    }

    public static int add(final String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_VALUE;
        }
        List<Integer> numbers = preprocess(input);
        return numbers.stream().reduce(0, Operation.PLUS::operate);
    }

    private static List<Integer> preprocess(final String input) {
        String expression = Delimiter.findExpression(input);
        return Delimiter.extractNumberFromExpression(expression);
    }

}
