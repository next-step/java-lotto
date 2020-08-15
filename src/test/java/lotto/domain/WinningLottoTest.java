package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("로또 결과 확인 (보너스볼X)")
    void match_without_bonus() {
        // given
        Lotto winningLotto = Lotto.fromString("16,22,33,41,44,45");
        LottoNumber bonusBall = LottoNumber.of(17);
        Lotto lotto = Lotto.fromString("16,22,33,40,42,43");

        // when
        WinningLotto winning = new WinningLotto(winningLotto, bonusBall);
        LottoRanking ranking = winning.match(lotto);

        // then
        assertThat(ranking).isEqualTo(LottoRanking.FOURTH);
    }

    @Test
    @DisplayName("로또 결과 확인 (보너스볼O)")
    void match_with_bonus() {
        // given
        Lotto winningLotto = Lotto.fromString("16,22,33,41,44,45");
        LottoNumber bonusBall = LottoNumber.of(17);
        Lotto lotto = Lotto.fromString("16,17,22,33,41,44");

        // when
        WinningLotto winning = new WinningLotto(winningLotto, bonusBall);
        LottoRanking ranking = winning.match(lotto);

        // then
        assertThat(ranking).isEqualTo(LottoRanking.BONUS);
    }
}
