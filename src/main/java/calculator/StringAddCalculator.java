package calculator;

import java.util.Objects;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private StringInput stringInput;

    public StringAddCalculator() {
    }

    public int add(String input) {
        this.stringInput = new StringInput(input);
        if (validate(input).equals(String.valueOf(ZERO))) {
            return ZERO;
        }
        return sum(numberSplit(input));
    }

    private int sum(String[] inputs) {
        int sum = ZERO;
        for (String input : inputs) {
            sum += minusValueValidate(input);
        }
        return sum;
    }

    private String validate(String input) {
        return stringInput.validate(input);
    }

    private String[] numberSplit(String input) {
        return stringInput.inputSplitWithCustom(input);
    }

    private int minusValueValidate(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringAddCalculator that = (StringAddCalculator) o;
        return Objects.equals(stringInput, that.stringInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringInput);
    }

}
