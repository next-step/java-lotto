package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningCombo;
import org.junit.jupiter.api.Test;

public class WinningComboTest {
    @Test
    void determinePrize() {
        // given
        Lotto lotto = Lotto.of(1, 2, 3, 4, 5, 45);

        Lotto winningLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        LottoNumber bonusBall = LottoNumber.from(45);
        WinningCombo winningCombo = new WinningCombo(winningLotto,bonusBall);

        // when
        Rank rank = winningCombo.determinePrize(lotto);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
    }
}
