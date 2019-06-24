package com.jaeyeonling.lotto.domain;

import com.jaeyeonling.lotto.exception.ConflictLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}
