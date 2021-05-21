package calculator;

import java.util.Arrays;

public class StringAddCalculator {

    public static final int DEFAULT_NUMBER = 0;

    public int splitAndSum(String input) {
        if (checkWhetherZeroOrNull(input)) {
            return DEFAULT_NUMBER;
        }
        Operands operands = new Operands(SplitUtil.splitByDelimiter(input));
        return sum(operands);
    }

    private int sum(Operands operands) {
        return operands.sum();
    }

    private boolean checkWhetherZeroOrNull(String input) {
        return input == null || input.isEmpty();
    }
}
