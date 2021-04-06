package lotto.stats;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBall;
import lotto.domain.stats.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("로또 번호를 추첨하여 각 번호당 일치시 2점, 보너스볼 일치시 1점으로 점수를 매긴다.")
    void lottoScoringIfMatchingBall() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(1, 2, 3, 4, 5, 6), new LottoBall(7));
        Lotto comparingLotto = new Lotto(1,2,3,4,5,7);

        long score = winningLotto.getScoreIfMatchingBall(comparingLotto);

        assertThat(score).isEqualTo(11L);
    }
}
