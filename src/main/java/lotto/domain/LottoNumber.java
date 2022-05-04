package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

import java.util.*;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final List<LottoNumber> LOTTO_NUMBER_CACHE = new ArrayList<>();
    private static final int CONSTANT_TO_CONVERT_NUMBER_TO_INDEX = 1;

    static {
        for (int i = MIN_LOTTO_NUMBER, len = MAX_LOTTO_NUMBER; i <= len; i++) {
            LOTTO_NUMBER_CACHE.add(new LottoNumber(i));
        }
    }

    private final Integer lottoNumber;

    private LottoNumber(final Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    static void checkRangeOfLottoNumber(int lottoNumber) {
        if (checkNumberRange(lottoNumber, MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)) {
            throw new InvalidLottoNumberException(lottoNumber);
        }
    }

    public static LottoNumber valueOf(final Integer lottoNumber) {
        checkRangeOfLottoNumber(lottoNumber);
        return LOTTO_NUMBER_CACHE.get(lottoNumber - CONSTANT_TO_CONVERT_NUMBER_TO_INDEX);
    }

    private static boolean checkNumberRange(int lottoNumber, int minNumber, int maxNumber) {
        return (lottoNumber < minNumber) || (lottoNumber > maxNumber);
    }

    static List<LottoNumber> values() {
        return LOTTO_NUMBER_CACHE;
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return this.lottoNumber.compareTo(lottoNumber.getLottoNumber());
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(lottoNumber, that.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
