package lotto.domain;

import lotto.validator.LottoNumberValidator;

import java.util.Objects;

public class LottoNumber {
    public static final int BOUND_START = 1;
    public static final int BOUND_END = 45;

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        LottoNumberValidator.checkBound(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber ofInt(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    public static LottoNumber ofString(String lottoNumber) {
        LottoNumberValidator.checkNumeric(lottoNumber);
        return new LottoNumber(Integer.parseInt(lottoNumber));
    }

    public Integer getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber1 = (LottoNumber) o;
        return Objects.equals(lottoNumber, lottoNumber1.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
