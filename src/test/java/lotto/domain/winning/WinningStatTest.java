package lotto.domain.winning;

import lotto.domain.Amount;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatTest {
    @Test
    @DisplayName("로또의 수익률 확인")
    void rateOfReturn() {
        final WinningStat winningStat = new WinningStat();
        final Lotto winning = Lotto.winningLotto("1,2,3,4,5,6");
        final Lotto fourth = new Lotto(new LottoNumbers("1,2,3,7,8,9"));
        final Amount amount = new Amount(14000);
        final LottoNumber bonusBall = new LottoNumber(5);
        winningStat.judgeWinning(winning, new WinningBall(fourth, bonusBall));

        assertThat(winningStat.rateOfReturn(amount))
                .isEqualTo(0.35F);
    }
}
