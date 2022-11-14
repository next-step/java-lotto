package lotto.model;

import java.util.*;


public class LottoNumber {
    public static final int LOTTO_END_NUMBER = 45;
    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber cacheLottoNumber(int number) {
        return CacheLotto.cache.get(number);
    }

    public static Map<Integer, LottoNumber> cache() {
        return CacheLotto.cache;
    }

    private static class CacheLotto {
        private static final Map<Integer, LottoNumber> cache = new HashMap<>();

        static {
            for (int i = 0; i < LOTTO_END_NUMBER; i++) {
                cache.put(i + 1, new LottoNumber(i + 1));
            }
        }
    }

    boolean isMatchNumber(LottoNumber winNums) {
        return winNums.number == this.number;
    }

    public int getNumber() {
        return number;
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
