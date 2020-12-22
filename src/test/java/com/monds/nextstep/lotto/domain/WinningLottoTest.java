package com.monds.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호로 로또 순위 반환")
    void testMatchingLottoRanking() {
        // given
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), LottoNumber.of(41));
        Lotto lotto = Lotto.of("1,2,3,10,11,12");
        // when
        LottoRanking ranking = winningLotto.matching(lotto);
        // then
        assertThat(ranking).isEqualTo(LottoRanking.FOURTH);
    }

    @Test
    @DisplayName("보너스 순위 반환")
    void testGetLottoRankingBonus() {
        // given
        WinningLotto winningLotto = new WinningLotto(Lotto.of("1,2,3,4,5,6"), LottoNumber.of(6));
        Lotto lotto = Lotto.of("1,2,3,4,6,10");
        // when
        LottoRanking ranking = winningLotto.matching(lotto);
        // then
        assertThat(ranking).isEqualTo(LottoRanking.BONUS);
    }
}
