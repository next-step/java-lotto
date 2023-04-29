package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {
    private static Map<Integer, LottoNumber> cache = new HashMap<>();
    static {
        for (int i = 1; i <= 45; i++) {
            cache.put(i, new LottoNumber(i));
        }
    }

    final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        return cache.get(number);
    }

    public int getNumber() {
        return number;
    }

    public boolean isEqual(LottoNumber lottoNumber) {
        return this.number == lottoNumber.getNumber();
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;

        LottoNumber that = (LottoNumber) o;

        return number == that.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
