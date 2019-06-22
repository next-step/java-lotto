package com.jaeyeonling.lotto;

import com.jaeyeonling.lotto.config.Env;

public class LottoNumber {

    private final int number;

    LottoNumber(final int number) {
        if (number < Env.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
        
        this.number = number;
    }
}
