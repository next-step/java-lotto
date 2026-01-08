package lotto.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private static final Map<Integer, LottoNumber> CACHE = new ConcurrentHashMap<>();

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber from(int value) {
        validateRange(value);
        return CACHE.computeIfAbsent(value, LottoNumber::new);
    }

    private static void validateRange(int value) {
        if (value < MIN || value > MAX) {
            throw new IllegalArgumentException("로또 번호는 " + MIN + " ~ " + MAX + " 사이여야 합니다. value=" + value);
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        return value == ((LottoNumber) o).value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
