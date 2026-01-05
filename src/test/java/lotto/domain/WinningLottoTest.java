package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    void 보너스볼_일치_여부를_확인할_수_있다() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(1, 2, 3, 4, 5, 6),
                LottoNumber.valueOf(7)
        );

        Lotto lottoWithBonus = new Lotto(1, 2, 3, 4, 5, 7);
        Lotto lottoWithoutBonus = new Lotto(1, 2, 3, 4, 5, 8);

        assertThat(winningLotto.matchBonusNumber(lottoWithBonus)).isTrue();
        assertThat(winningLotto.matchBonusNumber(lottoWithoutBonus)).isFalse();
    }
}
