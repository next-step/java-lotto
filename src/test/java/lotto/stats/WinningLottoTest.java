package lotto.stats;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    @DisplayName("당첨 번호와 보너스 볼은 서로 겹치면 안된다.")
    void noDuplicateLottoBonusNumber() {
        Lotto lotto = new Lotto(1,2,3,4,5,6);
        LottoBall bonusBall = new LottoBall(6);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinningLotto(lotto, bonusBall))
                .withMessage("보너스볼은 중복되지 않아야 합니다.");
    }
}
