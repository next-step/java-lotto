package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.ExceptionMessage;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN = 1;
    private static final int MAX = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validationCheck(number);
        return new LottoNumber(number);
    }

    private static void validationCheck(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_FOR_LOTTO_NUMBER.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LottoNumber) {
            LottoNumber other = (LottoNumber) obj;
            return this.number == other.number;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }
}
