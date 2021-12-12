package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    public static final int MIN = 1;
    public static final int MAX = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    private final int value;

    static {
        for (int i = MIN; i <= MAX; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        validate(number);
        this.value = number;
    }

    public static LottoNumber of(String number) {
        return of(Integer.parseInt(number));
    }

    public static LottoNumber of(int number) {
        if (CACHE.containsKey(number)) {
            return CACHE.get(number);
        }

        return new LottoNumber(number);
    }

    private void validate(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45의 숫자만 가능합니다.");
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
