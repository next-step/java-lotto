package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOTTO_MIN = 1;
    public static final int LOTTO_MAX = 45;
    private static Map<Integer, LottoNumber> cache = new HashMap<>();
    static {
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
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
