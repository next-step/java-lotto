package stringcalculator.domain;

import java.util.List;

public class StringCalculator {

    private static final String EMPTY_VALUE = "0";

    private List<OperandNumber> operands;
    private final Delimiter delimiter;

    public StringCalculator() {
        delimiter = new Delimiter();
    }

    public void preprocess(final String input) {
        operands = delimiter.findOperands(checkNullOrEmpty(input));
    }

    public int add(final String input) {
        preprocess(input);
        int sum = 0;
        for (OperandNumber operand : operands) {
            sum += operand.getNumber();
        }
        return sum;
    }

    private String checkNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            return EMPTY_VALUE;
        }
        return input;
    }
}
