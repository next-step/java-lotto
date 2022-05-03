package lotto.domain;

import lotto.exception.InvalidLottoNumberException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_CACHE = new HashMap<>();

    static {
        for (int i = LottoFactory.MIN_LOTTO_NUMBER, len = LottoFactory.MAX_LOTTO_NUMBER; i <= len; i++) {
            LOTTO_NUMBER_CACHE.put(i, new LottoNumber(i));
        }
    }

    private Integer lottoNumber;

    private LottoNumber(Integer lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    static void checkRangeOfLottoNumber(int lottoNumber) {
        if (checkNumberRange(lottoNumber, LottoFactory.MIN_LOTTO_NUMBER, LottoFactory.MAX_LOTTO_NUMBER)) {
            throw new InvalidLottoNumberException(lottoNumber);
        }
    }

    public static LottoNumber valueOf(int lottoNumber) {
        checkRangeOfLottoNumber(lottoNumber);
        new LottoNumber(lottoNumber);
        return LOTTO_NUMBER_CACHE.get(lottoNumber);
    }

    private static boolean checkNumberRange(int lottoNumber, int minNumber, int maxNumber) {
        return (lottoNumber < minNumber) || (lottoNumber > maxNumber);
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
