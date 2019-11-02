package calculator;

import java.util.Objects;

public class StringAddCalculator {
    private static final String ZERO = "0";
    private String input;

    public StringAddCalculator() {
        this(null);
    }

    public StringAddCalculator(String input) {
        this.input = input;
    }

    public int add(String input) {
        try {
            input = validate(input);
        } catch (NullPointerException e) {
            return Integer.parseInt(ZERO);
        }

        String[] numbers = numberSplit(input);
        return sum(numbers);
    }

    public int sum(String[] inputs) {
        int sum = 0;
        for (String input : inputs) {
            sum += Integer.parseInt(input);
        }
        return sum;
    }

    public String[] numberSplit(String input) {
        return input.split(",");
    }

    private String validate(String input) {
        if (input.isEmpty()) {
            return ZERO;
        }
        return nullValidate(input);
    }

    private String nullValidate(String input) {
        try {
            return input;
        } catch (NullPointerException e) {
            return ZERO;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringAddCalculator that = (StringAddCalculator) o;
        return Objects.equals(input, that.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input);
    }
}
