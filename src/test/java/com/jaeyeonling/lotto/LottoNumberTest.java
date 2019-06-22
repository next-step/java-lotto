package com.jaeyeonling.lotto;

import com.jaeyeonling.lotto.config.Env;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("LottoNumber 최소 값(" + Env.MIN_LOTTO_NUMBER + ") 생성")
    @Test
    void should_return_lottoNumber_when_minLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(Env.MIN_LOTTO_NUMBER);
        assertThat(lottoNumber).isNotNull();
    }

    @DisplayName("LottoNumber 최대 값(" + Env.MAX_LOTTO_NUMBER + ") 생성")
    @Test
    void should_return_lottoNumber_when_maxLottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(Env.MAX_LOTTO_NUMBER);
        assertThat(lottoNumber).isNotNull();
    }
}
