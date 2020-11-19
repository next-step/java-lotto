package lotto.domain;

import lotto.utils.MessageUtils;

public class LottoNumber {
    private static final int LOTTO_WINNING_MINIIMUM_NUM = 1;
    private static final int LOTTO_WINNING_MAXIMUM_NUM = 45;

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        validate(number);

        return new LottoNumber(number);
    }

    public int getNumber() {
        return this.number;
    }

    private static void validate(int number) {
        if (number < LOTTO_WINNING_MINIIMUM_NUM || number > LOTTO_WINNING_MAXIMUM_NUM) {
            throw new IllegalArgumentException(MessageUtils.LOTTO_NUMBER_INVALID_NUM);
        }
    }
}
