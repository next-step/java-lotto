package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            CACHE.put(i, new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int number) {
        LottoNumber lottoNumber = CACHE.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d부터 %d 사이의 숫자여야 한다", MIN_NUMBER, MAX_NUMBER));
        }
        return lottoNumber;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "LottoNumber{value= " + value + "}";
    }
}
