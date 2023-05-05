package lotto.domain;

import lotto.exception.LottoNumberOutOfRangeException;

public class LottoNumber {
    private final int lottoNumber;

    private static final int LOW_LIMIT = 1;
    private static final int HIGH_LIMIT = 45;
    private static final LottoNumber[] LOTTO_NUMBER_CACHE = new LottoNumber[45 + 1];

    static {

        for (int i = LOW_LIMIT; i <= HIGH_LIMIT; i++) {
            LOTTO_NUMBER_CACHE[i] = new LottoNumber(i);
        }
    }

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber of(int lottoNumber) {
        rangeValidate(lottoNumber);
        return LOTTO_NUMBER_CACHE[lottoNumber];
    }

    private static void rangeValidate(int lottoNumber) {
        if (LOW_LIMIT <= lottoNumber && lottoNumber <= HIGH_LIMIT) {
            return;
        }
        throw new LottoNumberOutOfRangeException();
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        return this.lottoNumber;
    }
}
