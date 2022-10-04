package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Number {
    private final List<Integer> numbers;

    public Number(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchCount(Number other) {
        List<Integer> numbers = new ArrayList<>(this.numbers);
        numbers.retainAll(other.numbers);
        return numbers.size();
    }

    public List<Integer> numbers() {
        return numbers;
    }
    
    public static Number of(String numbers) {
        if (isInvalid(numbers)) {
            throw new IllegalArgumentException("Number cannot be null or blank and must be a delimiter(,)");
        }
        return toNumber(numbers);
    }

    private static boolean isInvalid(String numbers) {
        return numbers == null || numbers.isBlank() || !numbers.contains(",");
    }

    private static Number toNumber(String numbers) {
        String[] values = numbers.split("[,]");
        if (values.length != 6) {
            throw new IllegalArgumentException("Number's count must be six.");
        }

        return toNumber(values);
    }

    private static Number toNumber(String[] values) {
        List<Integer> result = new ArrayList<>();
        for (String value : values) {
            result.add(parseInt(value));
        }
        return new Number(result);
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Only numbers between 1 and 45 are available.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Number number = (Number) o;
        return numbers.containsAll(number.numbers) && number.numbers.containsAll(numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public int count() {
        return numbers == null ? 0 : numbers.size();
    }
}
