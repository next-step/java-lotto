package calculator;

public class StringAddCalculator {

    public static final int DEFAULT_NUMBER = 0;

    public StringAddCalculator() {
    }

    public int splitAndSum(String input) {
        if (checkWhetherZeroOrNull(input)) {
            return DEFAULT_NUMBER;
        }
        Operands operands = SplitUtil.splitByDelimiter(input);
        return add(operands);
    }

    private int add(Operands operands) {
        return operands.sum();
    }

    private boolean checkWhetherZeroOrNull(String input) {
        return input == null || input.isEmpty();
    }
}
