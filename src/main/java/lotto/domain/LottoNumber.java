package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final int value;

    private static final Map<Integer, LottoNumber> values = new HashMap<>();
    static {
        IntStream.rangeClosed(MIN, MAX)
            .forEach(i -> values.put(i, new LottoNumber(i)));
    }

    public static LottoNumber from(Integer value) {
        if (value < MIN) {
            throw new IllegalArgumentException(MIN +" OR MORE");
        }

        if (value > MAX) {
            throw new IllegalArgumentException(MAX + " OR LESS");
        }

        return values.get(value);
    }

    public static LottoNumber from(String value) {
        return values.get(Integer.parseInt(value.trim()));
    }

    private LottoNumber(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
