package lotto.domain.number;

import java.security.InvalidParameterException;

public class LottoNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private int number;

    private LottoNumber(final int number) {
        verifyRange(number);
        this.number = number;
    }

    public static LottoNumber of(final int number) {
        return new LottoNumber(number);
    }

    private void verifyRange(final int number) {
        if (MAX_VALUE < number || MIN_VALUE > number) {
            throw new InvalidParameterException("1 ~ 45 사이의 숫자가 아닙니다.");
        }
    }
}
