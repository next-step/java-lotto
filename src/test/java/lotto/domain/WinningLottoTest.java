package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    @DisplayName("당첨 확인")
    void winLotto() {
        Lottos lottos = new Lottos(Arrays.asList(
                LottoFactory.createManualLotto("1, 2, 3, 25, 35, 12"),
                LottoFactory.createManualLotto("1, 2, 3, 27, 36, 14")));

        String winningNumbers = "1, 2, 3, 45, 32, 13";
        WinningLotto winningLotto = new WinningLotto(winningNumbers);
        List<Integer> count = winningLotto.checkWinningNumbers(lottos);

        assertThat(count).containsExactly(3, 3);
    }
}
