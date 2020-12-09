package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_VALUE = 1;

    public static final int MAX_VALUE = 45;

    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    private final int value;

    private LottoNumber(final int value) {
        this.value = value;
    }

    public static LottoNumber valueOf(final String value) {
        return valueOf(Integer.parseInt(value));
    }

    public static LottoNumber valueOf(final int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException(
                    String.format("로또번호는 %d와 %d 사이의 범위만 허용합니다. (입력 값: %d)", MIN_VALUE, MAX_VALUE, value));
        }
        return CACHE.computeIfAbsent(value, LottoNumber::new);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
        final LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(final LottoNumber lottoNumber) {
        return value - lottoNumber.value;
    }
}
