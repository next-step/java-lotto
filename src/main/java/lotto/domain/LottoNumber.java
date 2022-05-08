package lotto.domain;

import lotto.exception.InvalidBoundLottoNumber;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber> {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private final int value;

    private LottoNumber(int number) {
        if (isInValidBound(number)) {
            throw new InvalidBoundLottoNumber();
        }
        this.value = number;
    }

    public static LottoNumber valueOf(String value) {
        return valueOf(Integer.parseInt(value));
    }

    public static LottoNumber valueOf(int number) {
        LottoNumber cacheNumber = LottoNumberCache.findByNumber(number);
        if (cacheNumber != null) {
            return cacheNumber;
        }

        return LottoNumberCache.cacheLottoNumber(new LottoNumber(number));
    }

    private boolean isInValidBound(int lottoNumber) {
        return lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER;
    }

    public int toInt() {
        return value;
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

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.value, o.value);
    }

    private static class LottoNumberCache {
        private static final Map<Integer, LottoNumber> lottoNumbersCache = new HashMap<>();

        private static LottoNumber cacheLottoNumber(LottoNumber lottoNumber) {
            lottoNumbersCache.put(lottoNumber.toInt(), lottoNumber);
            return lottoNumber;
        }

        private static LottoNumber findByNumber(int number) {
            return lottoNumbersCache.get(number);
        }
    }
}
