package lotto.domain;

import lotto.exception.LottoNumberRangeException;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int lottoNumber;

    private static LottoNumber[] AllLottoNumberConst = new LottoNumber[MAX_LOTTO_NUMBER + 1];

    static {
        for(int i = MIN_LOTTO_NUMBER ; i <= MAX_LOTTO_NUMBER; i++){
            AllLottoNumberConst[i] = new LottoNumber(i);
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        validate(lottoNumber);
        return AllLottoNumberConst[lottoNumber];
    }

    private static void validate(int lottoNumber) {
        if (lottoNumber < MIN_LOTTO_NUMBER || lottoNumber > MAX_LOTTO_NUMBER) {
            throw new LottoNumberRangeException();
        }
    }
    public String value() {
        return Integer.toString(lottoNumber);
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
    public int compareTo(LottoNumber compare) {
        return lottoNumber - compare.lottoNumber;
    }
}
