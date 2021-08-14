package lotto.step2;

import lotto.step2.domain.WinningRank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankTest {

    @Test
    @DisplayName("당첨 번호와 일치하는 개수에 찾기")
    void findWinningRank() {
        WinningRank winningRank = WinningRank.findWinningRank(5);
        Assertions.assertThat(winningRank).isEqualTo(WinningRank.SECOND_PLACE);
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수에 찾기2")
    void findWinningRank2() {
        WinningRank winningRank = WinningRank.findWinningRank(2);
        Assertions.assertThat(winningRank).isEqualTo(WinningRank.NONE_PLACE);
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 개수에 찾기3")
    void findWinningRank3() {
        WinningRank winningRank = WinningRank.findWinningRank(6);
        Assertions.assertThat(winningRank).isEqualTo(WinningRank.FIRST_PLACE);
    }
}