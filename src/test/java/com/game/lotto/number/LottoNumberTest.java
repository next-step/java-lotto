package com.game.lotto.number;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    private final static int LOTTO_NUMBER = 3;
    private final static int LOTTO_NUMBER2 = 4;

    @Test
    void get_number() {
        LottoNumber lottoNumber = new LottoNumber(LOTTO_NUMBER);
        assertEquals(LOTTO_NUMBER, lottoNumber.getNumber());
    }

    @Test
    void compare_to() {
        LottoNumber lottoNumber = new LottoNumber(LOTTO_NUMBER);
        LottoNumber lottoNumber2 = new LottoNumber(LOTTO_NUMBER2);
        Assertions.assertThat(lottoNumber.compareTo(lottoNumber)).isZero();
        Assertions.assertThat(lottoNumber.compareTo(lottoNumber2)).isLessThan(0);
        Assertions.assertThat(lottoNumber2.compareTo(lottoNumber)).isGreaterThan(0);
    }
}