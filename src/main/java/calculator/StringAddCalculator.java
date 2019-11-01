package calculator;

import java.util.Objects;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private String input;

    public StringAddCalculator() {
        this(null);
    }

    public StringAddCalculator(String input) {
        this.input = input;
    }

    public int add(String input) {
        try {
            return validate(input);
        } catch (NullPointerException e) {
            return ZERO;
        }
    }

    public int validate(String input) {
        if (input.isEmpty()) {
            return ZERO;
        }
        return nullValidate(input);
    }

    public int nullValidate(String input) {
        try {
            return Integer.parseInt(input);
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
