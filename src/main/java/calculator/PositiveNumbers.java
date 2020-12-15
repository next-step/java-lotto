package calculator;

import java.util.Arrays;

public class PositiveNumbers {
    private final PositiveNumber[] values;

    public PositiveNumbers(PositiveNumber[] values) {
        this.values = values;
    }

    public PositiveNumbers() {
        this.values = new PositiveNumber[0];
    }

    public int sum() {
        int sum = 0;
        for (PositiveNumber positiveNumber : values) {
            sum += positiveNumber.getNumber();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositiveNumbers positiveNumbers = (PositiveNumbers) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(values, positiveNumbers.values);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }
}
