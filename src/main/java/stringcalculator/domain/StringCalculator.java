package stringcalculator.domain;

import java.util.List;

public class StringCalculator {

    private static final String EMPTY_VALUE = "0";

    public StringCalculator() {

    }

    public List<Integer> preprocess(final String input) {
        String expression = Delimiter.findExpression(checkNullOrEmpty(input));
        return Delimiter.extractNumberFromExpression(expression);
    }

    public int add(final String input) {
        List<Integer> numbers = preprocess(input);
        return numbers.stream().reduce(0, Operation.PLUS::operate);
    }

    private static String checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_VALUE;
        }
        return input;
    }
}
