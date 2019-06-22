package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.config.Env;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("로또 게임 구매 갯수 확인")
    @ParameterizedTest
    @ValueSource(ints = {
            1,
            10,
            300,
            400
    })
    void should_equals_lottoCount_when_buy(final int buyCount) {
        // given
        final LottoGame lottoGame = new LottoGame();

        final Money money = new Money(Env.PRICE_OF_LOTTO * buyCount);

        // when
        final List<Lotto> lottos = lottoGame.buy(money);

        // then
        assertThat(lottos.size()).isEqualTo(buyCount);
    }
}
