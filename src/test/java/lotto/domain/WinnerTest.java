package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @DisplayName("당첨갯수가 3개 이상이면 winner에 추가된다.")
    @Test
    void addWinnerSuccessTest() {
        final WinnerCount winner = new WinnerCount();
        winner.addWinner(3);

        final int winnerCount = winner.getWinnerCount(3);
        assertThat(winnerCount).isEqualTo(1);
    }

    @DisplayName("당첨갯수가 3개 미만이면 winner에 추가되지 않는다.")
    @Test
    void addWinnerFailTest() {
        final WinnerCount winner = new WinnerCount();
        winner.addWinner(2);

        final int winnerCount = winner.getWinnerCount(3);
        assertThat(winnerCount).isEqualTo(0);
    }

}