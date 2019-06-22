package com.jaeyeonling.lotto;

import com.jaeyeonling.lotto.config.Env;
import com.jaeyeonling.lotto.exception.LottoNumberShorterThanMinException;

public class LottoNumber {

    private final int number;

    LottoNumber(final int number) {
        if (number < Env.MIN_LOTTO_NUMBER) {
            throw new LottoNumberShorterThanMinException(number);
        }

        this.number = number;
    }
}
