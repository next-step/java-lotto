package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.ConflictLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class WinningLottoTest {

    @DisplayName("당첨번호와 보너스 번호 충돌 시 예외처리 ")
    @Test
    void should_throw_ConflictLottoNumberException() {
        // given
        final Lotto winningLotto = new FixtureLotto();
        final LottoNumber bonusLottoNumber = new LottoNumber(Lotto.COUNT_OF_LOTTO_NUMBER);

        // when / then
        assertThatExceptionOfType(ConflictLottoNumberException.class).isThrownBy(() -> {
            new WinningLotto(winningLotto, bonusLottoNumber);
        });
    }

    @DisplayName("로또 1등 당첨 테스트 ")
    @Test
    void should_return_jackpot() {
        // given
        final Lotto lotto = new FixtureLotto();
        final LottoNumber bonusLottoNumber = new LottoNumber(Lotto.COUNT_OF_LOTTO_NUMBER + 1);

        // when
        final WinningLotto winningLotto = new WinningLotto(lotto, bonusLottoNumber);
        final LottoPrize prize = winningLotto.match(lotto);

        // then
        assertThat(prize).isEqualTo(LottoPrize.JACKPOT);
    }

    @DisplayName("로또 2등 당첨 테스트 ")
    @Test
    void should_return_second() {
        // given
        final Lotto expectLotto = new FixtureLotto(LottoNumber.MIN + 1);
        final LottoNumber bonusLottoNumber = new LottoNumber(Lotto.COUNT_OF_LOTTO_NUMBER + 1);

        // when
        final WinningLotto winningLotto = new WinningLotto(new FixtureLotto(), bonusLottoNumber);
        final LottoPrize prize = winningLotto.match(expectLotto);

        // then
        assertThat(prize).isEqualTo(LottoPrize.SECOND);
    }
}
