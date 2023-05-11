package lotto.domain.winning;

import lotto.domain.lottocreator.LottoFactory;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    @Test
    @DisplayName("당첨 확인")
    void winLotto() {
        Lottos lottos = new Lottos(Arrays.asList("1, 2, 3, 25, 35, 12", "1, 2, 3, 27, 36, 14"));

        String winningNumbers = "1, 2, 3, 45, 32, 13";
        int bonusBall = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        List<WinningCount> count = winningLotto.checkWinningNumbers(lottos);

        assertThat(count).containsExactly(WinningCount.THREE, WinningCount.THREE);
    }

    @Test
    @DisplayName("보너스 볼, 로또 당첨 번호와의 중복 여부")
    void bonusBallNumberInWinningLottoNumber_exception() {
        String winningNumbers = "1, 2, 3, 45, 32, 13";
        int bonusBall = 2;
        assertThatThrownBy(() -> {
            new WinningLotto(winningNumbers, bonusBall);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("보너스 볼이 로또 당첨 번호와 중복됩니다.");
    }

    @Test
    @DisplayName("당첨 확인 - 보너스 볼")
    void winLotto_withBonusBall() {
        Lottos lottos = new Lottos(Arrays.asList("1, 2, 4, 25, 35, 12", "1, 2, 3, 45, 32, 7"));

        String winningNumbers = "1, 2, 3, 45, 32, 13";
        int bonusBall = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        List<WinningCount> count = winningLotto.checkWinningNumbers(lottos);

        assertThat(count).containsExactly(WinningCount.NONE, WinningCount.FIVE_WITH_BONUS_BALL);
    }
}
