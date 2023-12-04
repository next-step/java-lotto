package lotto;

import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
    WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6", 7);

    @DisplayName("등수 명수 체크")
    @Test
    void numberOfLotto() {
        Lottos lottos = new Lottos();
        lottos.manualLotto("1,2,3,4,5,6");
        lottos.manualLotto("1,2,3,4,5,7");
        lottos.manualLotto("1,2,3,4,5,8");

        winningNumbers.winLotto(lottos.getLottoList());
        assertThat(winningNumbers.getWinnerNumber(Rank.FIRST)).isEqualTo(1);
        assertThat(winningNumbers.getWinnerNumber(Rank.SECOND)).isEqualTo(1);
        assertThat(winningNumbers.getWinnerNumber(Rank.THIRD)).isEqualTo(1);
    }
}
