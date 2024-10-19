package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Number implements Comparable<Number> {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;

    private final int number;

    public Number(int number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException("Number must be between 1 and 45");
        }
        this.number = number;
    }

    public static List<Number> numbers(final Integer... numbers) {
        return Arrays.stream(numbers)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(final Number other) {
        return this.number - other.number;
    }
}
