package lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int VALUE_MIN = 1;
    public static final int VALUE_MAX = 45;

    private static final Map<Integer, LottoNumber> cache;

    static {
        cache = new HashMap<>();
        for (int i = VALUE_MIN; i <= VALUE_MAX; i++) {
            cache.put(i, new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int value) {
        if (value < VALUE_MIN || value > VALUE_MAX) {
            throw new IllegalArgumentException("잘못된 로또 숫자입니다.");
        }
        return cache.get(value);
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber other) {
        return Integer.compare(value, other.value);
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

    private static int getRandomNumber() {
        return new Random().nextInt(VALUE_MAX) + 1;
    }
}
