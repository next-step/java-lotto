package lotto.model;

import lotto.exception.InvalidNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number implements Comparable<Number> {

    public static final int MIN = 1;
    public static final int MAX = 45;
    private static Map<Integer, Number> CACHE = new HashMap<>();
    private int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        validateNumber(number);
        if (!CACHE.containsKey(number)) {
            CACHE.put(number, new Number(number));
        }
        return CACHE.get(number);
    }

    private static void validateNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new InvalidNumberException(number);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(Number other) {
        return Integer.compare(number, other.number);
    }
}
