package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Number implements Comparable<Number> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Map<Integer, Number> numberCache = new HashMap<>();
    private final int value;

    static {
        for (int i = MIN_NUMBER; i < MAX_NUMBER ; i++) {
            numberCache.put(i, new Number(i));
        }
    }

    private Number(int value) {
        this.value = value;
    }

    public static Number of(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException("1에서 45 사이의 수를 입력해주세요.");
        }

        return numberCache.get(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return MIN_NUMBER == number.MIN_NUMBER && MAX_NUMBER == number.MAX_NUMBER && value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Number o) {
        return 1;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
