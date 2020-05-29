package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static lotto.domain.LottoGameProperty.LOTTO_NUMBER_BEGIN_BOUND;
import static lotto.domain.LottoGameProperty.LOTTO_NUMBER_END_BOUND;

public class LottoNumber {
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();
    private final int value;

    private LottoNumber(final int value) {
        validate(value);
        this.value = value;
    }

    public static LottoNumber of(final int value) {
        return CACHE.computeIfAbsent(value, LottoNumber::new);
    }

    private void validate(int value) {
        if (value < LOTTO_NUMBER_BEGIN_BOUND || value > LOTTO_NUMBER_END_BOUND) {
            throw new IllegalArgumentException("로또 숫자는 1과 45사이여아 합니다.");
        }
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
