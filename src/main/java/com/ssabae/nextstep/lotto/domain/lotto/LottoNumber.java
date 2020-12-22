package com.ssabae.nextstep.lotto.domain.lotto;

import static com.ssabae.nextstep.lotto.Constant.LOTTO_MAX_VALUE;
import static com.ssabae.nextstep.lotto.Constant.LOTTO_MIN_VALUE;

import java.util.Objects;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class LottoNumber {

    private final static String LOTTO_NUMBER_OUT_BOUND_MESSAGE = "당첨 번호는 %d~%d 사이여야합니다..";

    private final int number;

    public static LottoNumber of(int number) {
        return new LottoNumber(number);
    }

    private LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private void validate(int number) {
        if (number < LOTTO_MIN_VALUE || number > LOTTO_MAX_VALUE) {
            String message = String.format(LOTTO_NUMBER_OUT_BOUND_MESSAGE, LOTTO_MIN_VALUE, LOTTO_MAX_VALUE);
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
