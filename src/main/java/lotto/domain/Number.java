package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Number implements Comparable<Number> {
    public static final String DELIMITER = ", ";

    private final int number;

    public Number(int number) {
        if (number < 0 || number > 45) {
            throw new IllegalArgumentException("Number must be between 0 and 45");
        }
        this.number = number;
    }

    public static List<Number> createWinningNumbers(final String winningNumber) {
        List<Number> winningNumbers = new ArrayList<>();
        String[] numbers = winningNumber.split(DELIMITER);
        for (String number : numbers) {
            winningNumbers.add(new Number(Integer.parseInt(number)));
        }
        return winningNumbers;
    }

    public int countMatch(final List<Number> numbers) {
        return (int) numbers.stream()
                .filter(number -> Objects.equals(number, this))
                .count();
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
    public int compareTo(Number other) {
        return this.number - other.number;
    }
}
