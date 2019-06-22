package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @DisplayName("로또 게임 1개 구매")
    @Test
    void should_return_oneLotto_when_buy() {
        // given
        final Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int lottoNumber = 1; lottoNumber <= Env.COUNT_OF_LOTTO_NUMBER_IN_LOTTO; lottoNumber++) {
            lottoNumbers.add(new LottoNumber(lottoNumber));
        }

        final Lotto lotto = new Lotto(lottoNumbers);
        final LottoGame lottoGame = new LottoGame(() -> lotto);

        final Money money = new Money(Env.PRICE_OF_LOTTO);

        // when
        final List<Lotto> lottos = lottoGame.buy(money);

        // then
        assertThat(lottos).containsExactly(lotto);
    }
}
