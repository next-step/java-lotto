package lotto.domain;

import lotto.exception.InvalidBoundLottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final int lottoNumber;

    @Deprecated
    private LottoNumber(int lottoNumber) {
        if (isInValidBound(lottoNumber)) {
            throw new InvalidBoundLottoNumber();
        }
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber valueOf(String value) {
        return valueOf(Integer.parseInt(value));
    }

    public static LottoNumber valueOf(int number) {
        return LottoNumberCache.lottoNumbersCache
                .stream()
                .filter(n -> n.lottoNumber == number)
                .findAny()
                .orElseThrow(InvalidBoundLottoNumber::new);
    }

    public static List<LottoNumber> cacheValues() {
        return Collections.unmodifiableList(LottoNumberCache.lottoNumbersCache);
    }

    private boolean isInValidBound(int lottoNumber) {
        return lottoNumber < MIN_NUMBER || lottoNumber > MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.lottoNumber, o.lottoNumber);
    }

    private static class LottoNumberCache {
        private static final List<LottoNumber> lottoNumbersCache;

        static {
            lottoNumbersCache = new ArrayList<>();
            for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
                lottoNumbersCache.add(new LottoNumber(i));
            }
        }
    }
}
