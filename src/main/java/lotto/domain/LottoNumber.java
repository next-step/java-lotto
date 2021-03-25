package lotto.domain;

import java.util.*;

public class LottoNumber {
    private final int number;
    private static final Map<Integer, LottoNumber> numbersCache;

    static {
        numbersCache = new HashMap<>();
        for (int i = LottoRule.min(); i <= LottoRule.max(); i++) {
            numbersCache.put(i, new LottoNumber(i));
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber create(int number) {
        LottoNumber lottoNumber = numbersCache.get(number);
        if (lottoNumber == null) {
            throw new IllegalArgumentException();
        }
        return lottoNumber;
    }

    public static int compare(LottoNumber first, LottoNumber second) {
        return Integer.compare(first.number, second.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
