package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningLottoTest {
    @Test
    @DisplayName("당첨 확인")
    void winLotto() {
        Lottos lottos = new Lottos(Arrays.asList(
                LottoFactory.createManualLotto("1, 2, 3, 25, 35, 12"),
                LottoFactory.createManualLotto("1, 2, 3, 27, 36, 14")));

        String winningNumbers = "1, 2, 3, 45, 32, 13";
        int bonusBall = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        List<Integer> count = winningLotto.checkWinningNumbers(lottos);

        assertThat(count).containsExactly(3, 3);
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
}
