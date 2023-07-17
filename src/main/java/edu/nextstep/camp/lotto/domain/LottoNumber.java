package edu.nextstep.camp.lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoNumber {

    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;

    private static final Map<Integer, LottoNumber> lottoNumbers;

    private final Integer lottoNumber;

    static {
        lottoNumbers = new HashMap<>();

        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber of(String lottoNumberStr){
        return of(Integer.parseInt(lottoNumberStr));
    }

    public static LottoNumber of(int lottoNumber){
        if (LOTTO_MIN_NUMBER > lottoNumber || lottoNumber > LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("lotto numbers are between 1 and 45.");
        }

        return lottoNumbers.get(lottoNumber);
    }

    private LottoNumber(int lottoNumber) {
        if (LOTTO_MIN_NUMBER > lottoNumber || lottoNumber > LOTTO_MAX_NUMBER){
            throw new IllegalArgumentException("lotto numbers are between 1 and 45.");
        }
        this.lottoNumber = lottoNumber;
    }

    public int compareTo(LottoNumber anotherNumber) {
        return lottoNumber.compareTo(anotherNumber.lottoNumber);
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
        return lottoNumber.hashCode();
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
