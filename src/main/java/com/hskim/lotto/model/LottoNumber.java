package com.hskim.lotto.model;

import com.hskim.lotto.exception.LottoExceptionMessage;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber {
    public static final int LOW_BOUND = 1;
    public static final int UPPER_BOUND = 45;

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        validateLottoNumber(lottoNumber);
        this.lottoNumber = lottoNumber;
    }

    private void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < LOW_BOUND) {
            throw new IllegalArgumentException(LottoExceptionMessage.LESS_THEN_LOW_BOUND.getMessage());
        }

        if (lottoNumber > UPPER_BOUND) {
            throw new IllegalArgumentException(LottoExceptionMessage.EXCEED_UPPER_BOUND.getMessage());
        }
    }

    public static List<LottoNumber> convertToLottoNumberList(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoNumber)) return false;
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
}

