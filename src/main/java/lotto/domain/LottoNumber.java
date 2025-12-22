package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final LottoNumber NONE = new LottoNumber(0);
    private static final Map<Integer, LottoNumber> Cache = new HashMap<>();

    static {
        for (int i = MIN; i <= MAX; i++) {
            Cache.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber get(int value) {
        LottoNumber lottoNumber = Cache.getOrDefault(value, NONE);
        if (lottoNumber == NONE) {
            throw new IllegalArgumentException("로또의 숫자는 1에서 45 사이여야합니다.");
        }
        return Cache.get(value);
    }

    public static LottoNumber get(String value) {
        return get(Integer.parseInt(value));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
