package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class LottoTest {

    @DisplayName("Lotto 는 LottoNumber " + Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO  + "를 가진다.")
    @Test
    void create() {
        // given
        final Set<LottoNumber> lottoNumbers = new HashSet<>();

        // when
        for (int lottoNumber = 1; lottoNumber <= Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO; lottoNumber++) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }

        // then
        final Lotto lotto = new Lotto(lottoNumbers);
    }

}
