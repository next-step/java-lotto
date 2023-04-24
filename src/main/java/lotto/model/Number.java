package lotto.model;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Number implements Comparable<Number> {
    private static final int START = 1;
    private static final int END = 45;
    private final int value;

    public Number(int value) {
        if (value < START || value > END) {
            throw new IllegalArgumentException("lotto number must be between 1 and 45 inclusive");
        }
        this.value = value;
    }

    public static List<Integer> all() {
        return IntStream.rangeClosed(START, END)
                .boxed()
                .collect(toList());
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Number) {
            Number number = (Number) o;
            return value == number.value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.value;
    }
}
